package com.example.practicandocontinuacasa;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.contactos_nav) {
            permisoLectura();
        } else if (id == R.id.compañeros_lista_nav) {
            fragment = new CompanerosListaFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
        } else if (id == R.id.promedio_nav) {
            fragment = new PromedioFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
        } else if (id == R.id.compañeros_fotos_nav) {
            fragment = new CompanerosFotosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Permiso lectura

    int READ_CONTACTS_CODE = 24;

    private void permisoLectura()
    {
        if (isReadStorageAllowed()){
            Toast.makeText(MainActivity.this, "Usted ya cuenta con el permiso",
                    Toast.LENGTH_SHORT).show();
        }else {
            requestStoragePermission();
        }
    }

    private boolean isReadStorageAllowed(){
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        boolean exito = false;
        if(result == PackageManager.PERMISSION_GRANTED){
            exito = true;
        }
        return exito;
    }

    private void requestStoragePermission(){
        ActivityCompat.requestPermissions(this, new String []{Manifest.permission.READ_CONTACTS},
                READ_CONTACTS_CODE);
    }

    public void onRequestPermissionsResult(int requestCode, String [] permissions, int [] grantResults){
        if(requestCode == READ_CONTACTS_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "Permiso Aceptado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "Permiso Denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
