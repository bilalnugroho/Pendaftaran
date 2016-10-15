package id.sch.smktelkom_mlg.tugas01.xiirpl0510.pendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spKelas;
    TextView tvHasil;
    TextView nama, textalamat;
    RadioButton lk, pr;
    String gender = null;
    CheckBox dasar, menengah, kosong;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dasar = (CheckBox) findViewById(R.id.sd);
        menengah = (CheckBox) findViewById(R.id.smp);
        kosong = (CheckBox) findViewById(R.id.tdk);

        lk = (RadioButton) findViewById(R.id.laki);
        pr = (RadioButton) findViewById(R.id.perempuan);

        textalamat = (TextView) findViewById((R.id.alamat));
        nama = (TextView) findViewById(R.id.textnama);

        spKelas = (Spinner) findViewById(R.id.spinnerkelas);

        tvHasil = (TextView) findViewById(R.id.hasil);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doClick();
            }
        });


    }

    private void doClick() {
        if (isValid()) {
            String name = nama.getText().toString();
            String alam = textalamat.getText().toString();
            if (lk.isChecked()) {
                gender = lk.getText().toString();
            } else if (pr.isChecked()) {
                gender = pr.getText().toString();
            }
            String hasilcb = "";
            int panjang = hasilcb.length();
            if (dasar.isChecked()) {
                hasilcb += "-" + dasar.getText().toString() + "\n";
            }
            if (menengah.isChecked()) {
                hasilcb += "-" + menengah.getText().toString() + "\n";
            }
            if (kosong.isChecked()) {
                hasilcb += "-" + kosong.getText().toString() + "\n";
            }
            if (hasilcb.length() == panjang) {
                hasilcb += "";
            }

            tvHasil.setText("Nama " + name + "\nAlamat " + alam + "\nJurusan " + spKelas.getSelectedItem().toString() + "\nJenis Kelamin "
                    + gender + "\nPernah Ikut PMR di " + hasilcb);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String name = nama.getText().toString();
        if (name.isEmpty()) {
            nama.setError("Nama Harus Diisi");
            valid = false;
        } else {
            nama.setError(null);
        }
        String alam = nama.getText().toString();
        if (alam.isEmpty()) {
            textalamat.setError("Alamat Harus Di Isi");
            valid = false;
        } else {
            textalamat.setError(null);
        }
        if (lk.isChecked()) {
            gender = lk.getText().toString();
        } else if (pr.isChecked()) {
            gender = pr.getText().toString();
        }
        if (gender == null) {
            tvHasil.setText("Anda belum memilih Jenis Kelamin");
            valid = false;
        }

        return valid;
    }
}

