package com.androidsquad.myportfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import java.io.File;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout layout;
    Dialog dialog;
    SkillDao skillDao;
    DAO educationDao;
    ProjectDAO projectDAO;
    CertificateDAO certificateDAO;
    DrawerLayout drawerLayout;
    ImageButton github,instagram,linkedIn;
    SharedPreferences sharedPreferences;
    CircleImageView circView;
    TextView myName,myPosition;
    View navHeader;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog=new Dialog(this);
        MaterialToolbar toolbar= findViewById(R.id.topAppBar);
        layout= findViewById(R.id.mylayout);
        github= findViewById(R.id.githublink);
        instagram=findViewById(R.id.instalink);
        linkedIn=findViewById(R.id.linkedinlink);
        setSupportActionBar(toolbar);
        drawerLayout= findViewById(R.id.drawer_layout);
        sharedPreferences = getSharedPreferences("MyLinks", Context.MODE_PRIVATE);
        NavigationView navigationView= findViewById(R.id.navigation_view);
        navHeader=navigationView.getHeaderView(0);
        circView=navHeader.findViewById(R.id.profilePic);
        myName=navHeader.findViewById(R.id.yash);
        myPosition=navHeader.findViewById(R.id.myPosition);
        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
        navigationView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawer(GravityCompat.START);
            switch(item.getItemId())
            {
                case R.id.education:
                    startActivity(new Intent(MainActivity.this,EducationDetails.class));
                    overridePendingTransition(15,0);
                    break;
                case R.id.techskills:
                    startActivity(new Intent(MainActivity.this,SkillDetails.class));
                    overridePendingTransition(15,0);
                    break;
                case R.id.project:
                    startActivity(new Intent(MainActivity.this,project_details.class));
                    overridePendingTransition(15,0);
                    break;
                case R.id.certifications:
                    startActivity(new Intent(MainActivity.this,CertificationDetails.class));
                    overridePendingTransition(15,0);
                    break;
                case R.id.resume:
                    startActivity(new Intent(MainActivity.this,ResumeActivity.class));
                    overridePendingTransition(15,0);
                default:
                    return true;
            }

            return false;
        });
        SaveLinks();
        github.setOnClickListener(view -> {
            String url=sharedPreferences.getString("Github","");
            openLink(url);
        });
        linkedIn.setOnClickListener(view -> {
            String url=sharedPreferences.getString("LinkedIn","");
            openLink(url);
        });
        instagram.setOnClickListener(view -> {
            String url=sharedPreferences.getString("Insta","");
            openLink(url);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.savedetails, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem)
    {

        switch (menuItem.getItemId())
        {
            case R.id.education:
                EducationDialog();
                return true;
            case R.id.Skills:
                SkillsDialog();
                return true;
            case R.id.project:
                ProjectDialog();
                return true;
            case R.id.certification:
                CertificationDialog();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }

    }

    private void ProjectDialog()
    {
        dialog.setContentView(R.layout.projects_dialog);
        dialog.setCancelable(false);
        ImageButton cancel= dialog.findViewById(R.id.cancel);
        EditText pTitle=dialog.findViewById(R.id.pTitle);
        EditText pDescription= dialog.findViewById(R.id.pDescription);
        EditText pDemoLink= dialog.findViewById(R.id.pDemoLink);
        Button save= dialog.findViewById(R.id.save);
        cancel.setOnClickListener(V->dialog.dismiss());
        save.setOnClickListener(view -> {
            Project p= new Project(pTitle.getText().toString(),pDescription.getText().toString(),pDemoLink.getText().toString());
            AsyncTask.execute(() -> AppDatabase.getInstance(MainActivity.this).projectDAO().insertProjectRecord(p));
        });
        dialog.show();
    }
    private void EducationDialog()
    {
        dialog.setContentView(R.layout.educationdetails_dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText editText1=dialog.findViewById(R.id.coursename);
        EditText editText2=dialog.findViewById(R.id.duration);
        EditText editText3=dialog.findViewById(R.id.institute);
        EditText editText4=dialog.findViewById(R.id.location);
        EditText editText5=dialog.findViewById(R.id.cgpa);
        Button save=dialog.findViewById(R.id.save);
        save.setOnClickListener(view -> {
            Education edu= new Education(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString(),editText5.getText().toString());
            AsyncTask.execute(() -> AppDatabase.getInstance(MainActivity.this).educationDao().insertRecord(edu));
        });
        ImageButton cancel= dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(V->dialog.dismiss());
        dialog.show();
    }
    private void CertificationDialog()
    {
        dialog.setContentView(R.layout.certifications_dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText certTitle=dialog.findViewById(R.id.certTitle);
        EditText issuedBy=dialog.findViewById(R.id.certifyingCompany);
        EditText link= dialog.findViewById(R.id.certLink);
        ImageButton cancel= dialog.findViewById(R.id.cancel);
        Button save= dialog.findViewById(R.id.save);
        cancel.setOnClickListener(V->dialog.dismiss());
        save.setOnClickListener(view -> {
            Certificate certificate= new Certificate(certTitle.getText().toString(),issuedBy.getText().toString(),link.getText().toString());
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    AppDatabase.getInstance(MainActivity.this).certificateDAO().insertCertificateRecord(certificate);
                }
            });
        });
        dialog.show();
    }
    protected void allocateActivityTitle(String title)
    {
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle(title);
        }
    }
    private void SkillsDialog()
    {
        dialog.setContentView(R.layout.skillsdialog);
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText skillEt=dialog.findViewById(R.id.skillName);
        ImageButton cancel= dialog.findViewById(R.id.cancel);
        Button save= dialog.findViewById(R.id.save);
        cancel.setOnClickListener(V->dialog.dismiss());
        save.setOnClickListener(view -> {
            Skill skill= new Skill(skillEt.getText().toString());
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    AppDatabase.getInstance(MainActivity.this).skillDao().insertSkill(skill);
                }
            });
        });
        dialog.show();
    }
    public void openLink(String url)
    {
        if(url.trim().length()!=0)
        {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
        }
        else
            Toast.makeText(this,"Not Provided Any Link",Toast.LENGTH_SHORT).show();

    }
    private void SaveLinks()
    {
        EditText link=findViewById(R.id.EditLink);
        ImageView imageView=findViewById(R.id.saveChanges);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        github.setOnLongClickListener(view -> {
            link.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(view1 -> {
                editor.putString("Github", link.getText().toString()).apply();
                link.setText("");
                link.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);

            });
            return true;
        });
        linkedIn.setOnLongClickListener(view -> {
            link.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(view12 -> {
                editor.putString("LinkedIn", link.getText().toString()).apply();
                link.setText("");
                link.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
            });
            return true;
        });
        instagram.setOnLongClickListener(view -> {
            link.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(view13 -> {
                editor.putString("Insta", link.getText().toString()).apply();
                link.setText("");
                link.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
            });
            return true;
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String s1 = sh.getString("imagePath", "null");
        if (s1 != null) {
            File imagefile = new File(s1);
            if (imagefile.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(imagefile.getAbsolutePath());
                circView.setImageBitmap(bitmap);
            }
        }
        SharedPreferences sh2=getSharedPreferences("my_preferences",MODE_PRIVATE);
        String name=sh2.getString("MyName","");
        myName.setText(name);
        myPosition.setText(sh2.getString("MyPosition",""));

    }
}