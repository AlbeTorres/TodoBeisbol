package com.example.eureka.todobisbol;

import android.content.Loader;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Loader.OnLoadCompleteListener, OnRenderListener, OnLoadCompleteListener
    {


    private String _currentPdf = "Historia del béisbol.pdf";
    private PDFView _pdfView;
    Toolbar toolbar;
    DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Historia del béisbol");
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this._pdfView = (PDFView)findViewById(R.id.pdfView);

        loadPdf(this._currentPdf);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_acerca) {
            toolbar.setTitle("Desarrollado por");
            loadPdf("acerca.pdf");

        } else if (id == R.id.action_fuente) {
            toolbar.setTitle("Bibliografía");
            loadPdf("Bibliografía.pdf");


        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        MenuItem menuItem = toolbar.getMenu().getItem(0);
        int id = item.getItemId();

        if (id == R.id.historia) {
            toolbar.setTitle("Historia del béisbol");
            loadPdf("Historia del béisbol.pdf");

        } else if (id == R.id.definición) {
            toolbar.setTitle("Definición de términos");
            loadPdf("Definición de términos.pdf");


        } else if (id == R.id.director) {
            toolbar.setTitle("Director de equipo y auxiliares");
            loadPdf("Director de equipo y auxiliares.pdf");


        } else if (id == R.id.bateador) {
            toolbar.setTitle("El bateador");
            loadPdf("El bateador.pdf");


        } else if (id == R.id.lanzador) {
            toolbar.setTitle("Lanzador");
            loadPdf("Lanzador.pdf");


        }else if (id == R.id.receptor) {
            toolbar.setTitle("Receptor");
            loadPdf("Receptor.pdf");


        }else if (id == R.id.cuadro) {
            toolbar.setTitle("Jugadores de cuadro");
            loadPdf("Jugadores de cuadro.pdf");


        }else if (id == R.id.jardineros) {
            toolbar.setTitle("Jardineros");
            loadPdf("Jardineros.pdf");


        }else if (id == R.id.táctica) {
            toolbar.setTitle("Táctica defensiva");
            loadPdf("Táctica defensiva.pdf");


        }else if (id == R.id.categorías) {
            toolbar.setTitle("Categorías inferiores");
            loadPdf("Categorías inferiores.pdf");


        }else if (id == R.id.logros) {
            toolbar.setTitle("Logros internacionales");
            loadPdf("Logros internacionales.pdf");


        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void loadPdf(String paramString) {
        this._currentPdf = paramString;
        this._pdfView.fromAsset(paramString).defaultPage(0).enableSwipe(true).onLoad(this).onRender(this).spacing(5).load();
    }

    @Override
    public void loadComplete(int i) {

    }

    @Override
    public void onLoadComplete(Loader loader, Object data) {

    }

    @Override
    public void onInitiallyRendered(int i, float v, float v1) {
        this._pdfView.fitToWidth();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        getWindow().setFlags(1024, 1024);
        loadPdf(this._currentPdf);
    }



}
