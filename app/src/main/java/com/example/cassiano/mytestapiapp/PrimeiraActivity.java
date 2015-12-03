package com.example.cassiano.mytestapiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.actionBarAndMenus.PopupActivity;
import com.example.cassiano.mytestapiapp.actionBarAndMenus.actionBar.ActionBarAndMenusActivity;
import com.example.cassiano.mytestapiapp.actionBarAndMenus.actionModes.ActionModeActivity1;
import com.example.cassiano.mytestapiapp.actionBarAndMenus.actionModes.ActionModeActivity2;
import com.example.cassiano.mytestapiapp.alarm.AlarmActivity;
import com.example.cassiano.mytestapiapp.asynctask.ThreadLearningActivity;
import com.example.cassiano.mytestapiapp.backStack.BackStackLearningActivity;
import com.example.cassiano.mytestapiapp.broadcasts.BroadcastActivity;
import com.example.cassiano.mytestapiapp.communication.FragmentsCommunicationtActivity;
import com.example.cassiano.mytestapiapp.dialogs.DialogsActivity;
import com.example.cassiano.mytestapiapp.fragments.DynamicFragmentActivity;
import com.example.cassiano.mytestapiapp.fragments.StaticFragmentActivity;
import com.example.cassiano.mytestapiapp.intents.IntentsActivity;
import com.example.cassiano.mytestapiapp.layouts.LinearLayoutLearningActivity;
import com.example.cassiano.mytestapiapp.layouts.RelativeLayoutLearningActivity;
import com.example.cassiano.mytestapiapp.listViewAndAdapter.ListViewAndAdapterLearningActivity;
import com.example.cassiano.mytestapiapp.listsAndFragments.ListsAndFragmentsActivity;
import com.example.cassiano.mytestapiapp.navigationDrawer.NavigationDrawerActivity;
import com.example.cassiano.mytestapiapp.navigationDrawer.DrawerMainActivity;
import com.example.cassiano.mytestapiapp.notificacoes.NotificacoesActivity;
import com.example.cassiano.mytestapiapp.notificacoes.counterNotification.CounterNotificationActivity;
import com.example.cassiano.mytestapiapp.services.ServicesActivity;
import com.example.cassiano.mytestapiapp.spinner.SpinnerActivity;
import com.example.cassiano.mytestapiapp.actionBarAndMenus.upNavigation.UpNavigationActivity;
import com.example.cassiano.mytestapiapp.tabs.TabsActivity;

/**
 * Created by Cassiano on 19/11/2015.
 */
public class PrimeiraActivity extends Activity {

    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
    }

    public void next(View view) {

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("msg1", "Mensagem da primeira activity");
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){
            String msgRetorno = data.getStringExtra("msgRetorno");
            Toast.makeText(this, msgRetorno, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public void aprenderThread(View view) {

        Intent intent = new Intent(this, ThreadLearningActivity.class);
        startActivity(intent);

    }

    public void aprenderAsyncTask(View view) {
        Intent intent = new Intent(this, AsyncTaskLearningActivity.class);
        startActivity(intent);
    }

    public void aprenderLinearLayout(View view) {
        Intent intent = new Intent(this, LinearLayoutLearningActivity.class);
        startActivity(intent);
    }

    public void aprenderRelativeLayout(View view) {
        Intent intent = new Intent(this, RelativeLayoutLearningActivity.class);
        startActivity(intent);
    }

    public void aprenderProgressBar(View view) {
        Intent intent = new Intent(this, ProgressBarActivity.class);
        startActivity(intent);
    }

    public void aprenderFragmentsEstaticos(View view) {
        Intent intent = new Intent(this, StaticFragmentActivity.class);
        startActivity(intent);
    }

    public void aprenderFragmentsDinamicos(View view) {
        Intent intent = new Intent(this, DynamicFragmentActivity.class);
        startActivity(intent);
    }

    public void aprenderComunicacaoEntreFragments(View view) {
        Intent intent = new Intent(this, FragmentsCommunicationtActivity.class);
        startActivity(intent);
    }

    public void aprenderBackStack(View view) {
        Intent intent = new Intent(this, BackStackLearningActivity.class);
        startActivity(intent);
    }

    public void aprenderListViewAndAdapter(View view) {
        Intent intent = new Intent(this, ListViewAndAdapterLearningActivity.class);
        startActivity(intent);
    }

    public void aprenderListasEmFragments(View view) {
        Intent intent = new Intent(this, ListsAndFragmentsActivity.class);
        startActivity(intent);
    }

    public void aprenderSpinners(View view) {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }

    public void aprenderDialogs(View view) {
        Intent intent = new Intent(this, DialogsActivity.class);
        startActivity(intent);
    }

    public void aprenderActionBarAndMenus(View view) {
        Intent intent = new Intent(this, ActionBarAndMenusActivity.class);
        startActivity(intent);
    }

    public void aprenderUpNavigation(View view) {
        Intent intent = new Intent(this, UpNavigationActivity.class);
        startActivity(intent);
    }

    public void aprenderActionMode1(View view) {
        Intent intent = new Intent(this, ActionModeActivity1.class);
        startActivity(intent);
    }

    public void aprenderActionMode2(View view) {
        Intent intent = new Intent(this, ActionModeActivity2.class);
        startActivity(intent);
    }

    public void aprenderPopups(View view) {
        Intent intent = new Intent(this, PopupActivity.class);
        startActivity(intent);
    }

    public void aprenderNavigationDrawer(View view) {
        Intent intent = new Intent(this, NavigationDrawerActivity.class);
        startActivity(intent);
    }

    public void aprenderTabs(View view) {
        Intent intent = new Intent(this, TabsActivity.class);
        startActivity(intent);
    }

    public void aprenderIntentsImplicitas(View view) {
        Intent intent = new Intent(this, IntentsActivity.class);
        startActivity(intent);
    }

    public void aprenderBroadcasts(View view) {
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }

    public void aprenderNotificacoes(View view) {
        Intent intent = new Intent(this, NotificacoesActivity.class);
        startActivity(intent);
    }

    public void abrirNavigation(View view) {
        Intent intent = new Intent(this, DrawerMainActivity.class);
        startActivity(intent);
    }

    public void abrirContador(View view) {
        Intent intent = new Intent(this, CounterNotificationActivity.class);
        startActivity(intent);
    }

    public void aprenderAlarme(View view) {
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }

    public void aprenderServices(View view) {
        Intent intent = new Intent(this, ServicesActivity.class);
        startActivity(intent);
    }
}
