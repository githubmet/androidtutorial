package com.example.kkldfkld.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;  //bizim veri tabaninda ki sanal yerimiz gibi

public class P027BSOLiteOpenHelperClass {

    private static final String databaseName ="dbName";
    private static final int databaseVersionNumber = 1;

    private static final String tableName ="tblName";
    public static final String calisanId ="_Id";
    public static final String calisanName ="_Name";
    public static final String calisanSurname ="_Surname";


    private final Context context;
    private SQLiteDatabase sqLiteDatabase;
    private CreateDatabaseClass createDatabaseClass;

    public P027BSOLiteOpenHelperClass(Context context){
        this.context=context;
    }

    public P027BSOLiteOpenHelperClass openMtd(){
        createDatabaseClass=new CreateDatabaseClass(this.context);
        sqLiteDatabase= createDatabaseClass.getWritableDatabase();

        return this;
    }
    public void closeMtd(){
        sqLiteDatabase.close();
    }
    public long InsertMtd(String name, String surname){

        ContentValues contentValues=new ContentValues();
        contentValues.put(calisanName,name);
        contentValues.put(calisanSurname, surname);

        return sqLiteDatabase.insert(tableName,null,contentValues);
    }
    public String GetAllInfoMtd(){

        String[] columns={calisanId,calisanName,calisanSurname};
        Cursor cursor= sqLiteDatabase.query(tableName,columns,null,null,null,null,null);
        String katar="";

        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            katar=cursor.getInt(0)+" "+cursor.getString(1)+ " "+cursor.getString(2)+"\n";
        }

        return katar;
    }
    public String GetNameById(String Id){
        String[] columns={calisanId,calisanName,calisanSurname};

        Cursor cursor= sqLiteDatabase.query(tableName,columns,this.calisanId+" = "+Id,null,null,null,null);
        String katar="";

        if(cursor !=null){
            cursor.moveToNext();
            katar= cursor.getString(1);
        }
        return katar;
    }
    public String GetSurnameById(String Id){

        String[] columns={calisanId,calisanName,calisanSurname};
        Cursor cursor= sqLiteDatabase.query(tableName,columns,calisanId+" = "+Id,null,null,null,null);
        String katar="";
        if(cursor !=null){
            cursor.moveToNext();
            katar= cursor.getString(2);
        }
        return katar;
    }

    public int DeleteInfoById(int Id){
        return sqLiteDatabase.delete(tableName,calisanId+" = "+Id,null);
    }

    public int UpdateNameAndSurnameById(String name, String surname,int Id){

        ContentValues contentValues=new ContentValues();
        contentValues.put(this.calisanName,name);
        contentValues.put(calisanSurname,surname);
        return  sqLiteDatabase.update(tableName,contentValues,calisanId+" = "+Id,null);

    }

    public class CreateDatabaseClass extends SQLiteOpenHelper{

        public CreateDatabaseClass(Context context ){  //, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, databaseName, null, databaseVersionNumber);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "Create table "+tableName+" ("+
                            calisanId+" integer primary key autoincrement, "+  //dikkat autoincreAment degil
                            calisanName+" text not null, "+
                            calisanSurname+" text not null);"
            );
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists "+tableName);
        }
    }
}

/*
Insert Statements Old Way
>db.execSQL(insert statement)
        >Normal sql komut satırı yazman gerekir

        Insert Statement #2
        >ContentValues contentValues=new ContentValues();
        For every column specify the name of column as key and the data to be put as value
        >contentValues.put("keyName","Value");
        >long kontrol=db.insert(tableName,null,contentValues)
        if kontrol ==-1 o zaman kayit yapilamamistir.

        >null parametresi bize database null bir deger atamamizi saglar
        >ContentValues contentValues=new ContentValues(); //bu sekilde bos kayit
        >db.insert(tableName,columnName(null olacak),contentValues); //zaten ikinci parametre nullColumnHack olarak gecer.

        Wkat is the best way to insert data?
        >Create a method[call it insert]
        >Take all the values to be insertted as parameters to the method
        >Use the #2 insert technique
        >Return the long Id which specifies if the row was inserted successfully or not!

android.database.Cursor
>Provides random read-write access to the result set returned by a database query.
>Cursor implementations are not required to be synchronized so code using a Cursor
from multiple threads should perform its own sychronization.
>String .getColumnName(int columnIndex) -->adver
>int .getCount() -->kac adet
>get... (int columnIndex) -->deger al
>boolean moveToNext()  -->ilerle

db.query(...) returns Cursor
>db.query(String tableName, String[] columns, String selection, String[] selectinArgs,
 String groupBy, String having, String orderBy)
columns= list of columns to process, null retruns all
selection, selectinArgs, groupBy, having, orderBy= extra conditions on the SQL statemnet
to return rows satisfying certain criteria
>db.query(tableName,columns,null,null,null, null, null);  //bu bir Cursor object donderir ve bu bir table icerir

>while(cursor.moveToNext()){      //yani row olarak burada ilerle
String name=cursor.getString(1);    //row icersinde sutun olarak bunlara bak demek
String surname=cursor.getString(2);    //bu kadar basit
}


* dikkat burada bir class icersinde CreateDatabase class olustrumamiz bize bu class in column Name lerine ulasmamizi sagliyor
* en onemli ozellik budur
* bu yazim standart haline gelmistir
*

//switch (v.getId()){  //.setId=2211 verdiginde direk olarak da yakalayabilirsin
//        case 2211:
//        break;
//        case 2222:
//        break;
//        }

>Files stored in the files folder are persistent and remain till you delete them.
        >Sometimes, you want to store files temporarily [CACHE them].
        >Use getCacheDir() [internal storage] or getExternalCacheDir()[Exterbal storage] to get reference to
        your app specific absolute path for the cache directory
        >Use the File class to create a file inside that cache folder
>The files are stored in data/data/<package-name>/cache folder

        >SharedPreferences
        Storing data internally in XML files.
        More efficient due to less read/write overhead.
        Only primitive types and at most, arrays of string can be stored

        >Internal/External storage
        Storing data and files to the phone's external Secure Digital(SD) card.
        Less efficient
        Store complex data, media, images

Internal Storage
>Internal allows you to read and write to files that are associated with each application's internal memory.
        >These files can oly be accessed by the application and cannot be accessed by other applications or users.
        >when application is uninstall the data automotically is unistall.

        >Your app's internal storage directory is specified by your app's package name in a special location of the
        Android file system.
        >Other apps and users cannot browse your internal directories and do not have read or write access unless you
        explicity set the files to be readable or writable.
        >When you use MODE_PRIVATE tor your files on the internal storage, they are never accessible to other apps.
        >Internal storage is best when you want to be sure that neither the user nor other apps can access your files.

        >String FILENAME="mytext.txt";
        >String string="hello world";
        >FileOutputStream fos=openFileOutput(FILENAME,Context.MODE_PRIVATE);
        >byte[] buffer=string.getBytes();
        >fos.write(buffer);

Hot to write to external storage
>Add into your manifest file the WRITE_EXTERNAL_STORAGE permission
        >Check the external storage to see if its MOUNTED, READ_ONLY, or failure using getExternalStorageState() method
        >Get the files directory by calling
        getExternalStorageFilesDir(String type) or
        getExternalStoragePublicDirectory(String type) or
        getExternalStorageDirectory()
        >Use a FileInputStream and FileOutputStream to do required operations

        External Storage Availability Test
        boolean isAvailable=false;
        boolean isWriteable=false;
        String state=Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state){
//We can read and write the media
//yani isAvailable=isWritable=true;
        }
        else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state({
//We can only read the media
//isAvaliable=true but isWritable=false;
        }
        else{
//Something else is wrong.It may be one of many other states, but we need to know is we can neitgher read nor write
        }
*/

