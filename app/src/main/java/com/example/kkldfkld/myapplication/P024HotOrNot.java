package com.example.kkldfkld.myapplication;
                                                      //tum isler burada donuyor!!!
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;  //insert update delete create islemleri icin
import android.database.sqlite.SQLiteOpenHelper; //database olusturmak ve guncellemek icin
import android.content.Context;
import android.content.ContentValues;

import android.database.Cursor; //This interface provides random read-write access to the result set returned by a database query.

public class P024HotOrNot {

    public static final String key_RowId="_Id";
    public static final String key_Name="persons_Name";
    public static final String key_Hotness="persons_Hotness";

    private static final String database_Name="HotOrNotdb";
    private static final String database_Table="peopleTable";
    private static final int database_Version = 1 ;

    private DbHelper ourHelper; //instanceOfThisClass;
    private final Context ourContext;  //instanceOfThisContext;
    private SQLiteDatabase sqLiteDatabase;

    public P024HotOrNot(Context contextC) {  //dikkat kurucu metod  Context al�r ve buradaki context yapar
        ourContext=contextC;
    }

    //dikkat burada bir hata olmasi durumunda P024SqlLite.class switch ifadesinde hata yakalan�r!!!!
    //Context, database olusturulacak class gonderilir ve database elde edilir
    public P024HotOrNot open() throws SQLException {  //dikkat bunu biz yazdik yeri de onemli  Actigimiz gibi kapatmasini da bilmeliyiz

        ourHelper=new DbHelper(ourContext);
        sqLiteDatabase=ourHelper.getWritableDatabase();

        return this;
    }
    public void close(){  //bunu da biz yazd�k
        ourHelper.close();
    }  //database kapat

    public long createEntry(String name, String hotness) {  //tipki Bundle gibi islem yapacagiz
        ContentValues contentValues=new ContentValues();
        contentValues.put("persons_Name",name);
        contentValues.put(key_Hotness, hotness);
        return sqLiteDatabase.insert(database_Table,null,contentValues);  //dikkat long olarak return edildi
    }

    public String getData() {

        String[] colums =new String[]{key_RowId,key_Name,key_Hotness};
        Cursor cursor =sqLiteDatabase.query(database_Table,colums,null,null,null,null,null);
        String result ="";

//        int iRow=cursor.getColumnIndex(key_RowId);
//        int iName=cursor.getColumnIndex(key_Name);
//        int iHotness=cursor.getColumnIndex(key_Hotness);

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){  //for kelime hali o kadar
//            result=result + cursor.getString(iRow) + " "+cursor.getString(iName) + " " +cursor.getString(iHotness)+ "\n";  //harika
            result=result + cursor.getString(0) + " "+cursor.getString(1) + " " +cursor.getString(2)+ "\n";  //harika
        }
        return result;
    }

    public String getName(String rowId) throws SQLException{  //dikkat bir alttaki method dan farkina iyi bak neden long veri tipi kullanilmis bilmiyorum ama
        String[] colums =new String[]{key_RowId,key_Name,key_Hotness}; //birsey degismedi
        Cursor cursor=sqLiteDatabase.query(database_Table,colums,key_RowId+"="+rowId,null,null,null,null);

        if(cursor !=null){
            cursor.moveToFirst();  //yani 3 sütonluk alanda olmasada tek sutunun ilk sutununa git. Cursor duran ADAM gibi
            String name=cursor.getString(1);  //dikkat 0 , 1 , 2  sutun isimleri
            return name;
        }
        return null;
    }

    public String getHotness(long rowLong) throws SQLException {
        String[] colums =new String[]{key_RowId,key_Name,key_Hotness};
        Cursor cursor=sqLiteDatabase.query(database_Table,colums,key_RowId+"="+rowLong,null,null,null,null);

        if(cursor !=null){
            cursor.moveToFirst();
            String hotness=cursor.getString(2);
            return hotness;
        }
        return null;
    }

    public void updateEntry(long rowLong2, String name, String hotness) throws SQLException {
        ContentValues contentValues=new ContentValues();
        contentValues.put(key_Name,name);
        contentValues.put(key_Hotness,hotness);

        sqLiteDatabase.update(database_Table,contentValues,key_RowId+"="+rowLong2,null);

    }

    public void deleteEntry(long rowLong3) throws SQLException {
        sqLiteDatabase.delete(database_Table,key_RowId+"="+rowLong3,null);
    }

    //aslinda bu sinif 1 numara
    private static class DbHelper extends SQLiteOpenHelper {

        //dikkat kurucu metod ever extends SQLiteOpenHelper yaparsan bu mutlak
        public DbHelper(Context context){      //, String name, SQLiteDatabase.CursorFactory factory, int version) { na gerek yoktur
            super(context, database_Name, null, database_Version); //you must be super happy!
        }
        @Override
        public void onCreate(SQLiteDatabase db) {  //first time every create database
            //SETUP DATABASE
            db.execSQL( "CREATE TABLE " + database_Table + " (" +
                    key_RowId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            key_Name + " TEXT NOT NULL, " +
                            key_Hotness + " TEXT NOT NULL);"
            );
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + database_Table);  //dikkat database bir table olarak degerlendirilir!!!!
        }
    }
}



















