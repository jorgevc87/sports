package com.pe.asistente.deportivo.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentSender;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

public class Cronometro extends Service {
    private mTimer crono;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "Servicio iniciado", Toast.LENGTH_SHORT).show();
        crono = new mTimer();
        crono.execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        crono.cancel(true);
        Toast.makeText(getApplicationContext(), "Servicio Destruido", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class mTimer extends AsyncTask<String, Integer, String> {
        private int counter = 0;
        private boolean continuar = false;

        public mTimer() {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            continuar = true;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                while (continuar) {
                    counter++;
                    publishProgress(counter);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            continuar = false;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            Toast.makeText(getApplicationContext(), "Contador: " + values[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
