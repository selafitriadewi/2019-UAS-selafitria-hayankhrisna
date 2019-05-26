package com.selafitriadewi.uas_alquran.presentation.listsurah;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.selafitriadewi.uas_alquran.base.BasePresenter;
import com.selafitriadewi.uas_alquran.database.DatabaseContract;
import com.selafitriadewi.uas_alquran.database.DatabaseHelper;
import com.selafitriadewi.uas_alquran.model.Surah;

import java.util.ArrayList;

class ListSurahPresenter extends BasePresenter<ListSurahView> {

        ListSurahPresenter(ListSurahView view) {
        super.attach(view);
        }

        void loadSurah(String loadTerjemahan) {
        SQLiteDatabase database = DatabaseHelper.getDatabase();
        Cursor cursor = database.query(DatabaseContract.TableSurah.TABLE_SURAH, null, null, null, null, null, null);

        ArrayList<Surah> data = new ArrayList<>();
        if (cursor.moveToFirst()) {
        do {
        String surah = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TableSurah.SURAH));
        String ayat = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TableSurah.AYAT));
        String terjemahan = cursor.getString(cursor.getColumnIndexOrThrow(loadTerjemahan));
        String jumlahAyat = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TableSurah.JUMLAH_AYAT));

        data.add(new Surah(surah , ayat , terjemahan , jumlahAyat));
        } while (cursor.moveToNext());
        }
        mView.onLoad(data);

        cursor.close();
        database.close();
        }
        }
