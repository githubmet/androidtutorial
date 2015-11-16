package com.example.kkldfkld.myapplication;

/*
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import android.content.Context;
import android.content.ContentValues;


public class P027BSOLiteOpenHelperClass {

    private static final String databaseName="dbDatabaseName";
    private static final int version=1;

    private final Context context;

    public static final String tableName="tableNametbl";
    public static final String calisanId="calicanId";
    public static final String calisanName="calisanName";
    public static final String calisanSurname="calisanSurname";


    private SQLiteDatabase sqLiteDatabase;

    public P027BSOLiteOpenHelperClass(Context context){
        this.context=context;
    }
    public P027BSOLiteOpenHelperClass openMtd(){
        CreateSQLiteDatabase createSQLiteDatabase=new CreateSQLiteDatabase(this.context);
        SQLiteDatabase sqLiteDatabase= createSQLiteDatabase.getWritableDatabase();

        return this;
    }

    public void closeMtd(){
        sqLiteDatabase.close();
    }

    public long InsertMtd(String name,String surname){
        ContentValues contentValues=new ContentValues();
        contentValues.put(calisanName,name);
        contentValues.put(calisanSurname, surname);
        return sqLiteDatabase.insert(tableName,null,contentValues);
    }

    public String GetAllInfoMtd(){
        String[] columns={calisanId, calisanName, calisanSurname};

        Cursor cursor = sqLiteDatabase.query(tableName,columns,null,null,null,null,null);
        String katar="";
        if(cursor !=null){
            for(cursor.moveToFirst();!cursor.isAfterLast() ;cursor.moveToNext()){
                katar=cursor.getInt(0)+ " "+cursor.getString(1)+ " "+ cursor.getString(2)+ "\n";
            }
        }
        return katar;
    }

    public String  GetNameById(String Id){
        String[] columns={calisanId,calisanName,calisanSurname};
        Cursor cursor= sqLiteDatabase.query(tableName,columns,calisanId+ "="+Id,null,null,null,null);
        String name="";

        if(cursor != null){
            cursor.moveToFirst();
            name=cursor.getString(1);
        }
        return name;
    }

    public String GetSurnameById(String Id){
        String[] columns={calisanId,calisanName,calisanSurname};
        Cursor cursor= sqLiteDatabase.query(tableName, columns, calisanId + "=" + Id, null, null, null, null);
        String surname="";

        if(cursor !=null){
            surname=cursor.getString(2);
        }
        return surname;
    }

    public void DeleteInfoById(String Id){

        sqLiteDatabase.delete(tableName,calisanId+"="+Id,null);
    }
    public void UpdateNameAndSurnameById(String name,String surname, String Id){
        ContentValues contentValues=new ContentValues();
        contentValues.put(calisanName,name);
        contentValues.put(calisanSurname,surname);

        sqLiteDatabase.update(tableName,contentValues,calisanId+"="+Id,null);
    }

    public class CreateSQLiteDatabase extends SQLiteOpenHelper{

        public CreateSQLiteDatabase(Context context){    //, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, databaseName, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table "+tableName+" ( "+
                            calisanId + " integer primary key autoincrement, "+
                            calisanName + " text not null, "+
                            calisanSurname + " text not null );"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists "+tableName);
        }
    }

}
*/











import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

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
