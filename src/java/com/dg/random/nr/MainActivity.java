package com.dg.random.nr;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.dg.random.nr.RequestNetwork.RequestListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends Activity {
    private String CurrentVersion = "";
    private Builder UpdateIO_Dialog;
    private Intent UpdateIO_Intent = new Intent();
    private HashMap<String, Object> UpdateIO_Map = new HashMap();
    private RequestNetwork UpdateIO_ReqNetwork;
    private RequestListener _UpdateIO_ReqNetwork_request_listener;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private TextView character;
    private Builder dlg;
    private String doNotUseThisForSth = "";
    private EditText edittext1;
    private Builder error_dlg;
    private LinearLayout header;
    private TextView header_txt;
    private Intent i = new Intent();
    private ImageView imageview1;
    private ArrayList<String> letters = new ArrayList();
    private LinearLayout linear2;
    private LinearLayout linear25;
    private LinearLayout linear26;
    private LinearLayout linear27;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout main;
    private LinearLayout main_bg;
    private Button new_btn;
    private HashMap<String, Object> news = new HashMap();
    private ArrayList<HashMap<String, Object>> newss = new ArrayList();
    private TextView prefix;
    private String randgetbackstr = "";
    private SharedPreferences sp;
    private String text = "";
    private TextView textview10;
    private TextView textview11;
    private TextView textview2;
    private TextView textview3;
    private TextView textview7;
    private TextView textview8;
    private TextView textview9;
    private ScrollView vscroll1;
    private Builder wa_list;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.header = (LinearLayout) findViewById(R.id.header);
        this.main_bg = (LinearLayout) findViewById(R.id.main_bg);
        this.header_txt = (TextView) findViewById(R.id.header_txt);
        this.linear25 = (LinearLayout) findViewById(R.id.linear25);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.main = (LinearLayout) findViewById(R.id.main);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear27 = (LinearLayout) findViewById(R.id.linear27);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.textview10 = (TextView) findViewById(R.id.textview10);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.new_btn = (Button) findViewById(R.id.new_btn);
        this.button5 = (Button) findViewById(R.id.button5);
        this.prefix = (TextView) findViewById(R.id.prefix);
        this.edittext1 = (EditText) findViewById(R.id.edittext1);
        this.character = (TextView) findViewById(R.id.character);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear26 = (LinearLayout) findViewById(R.id.linear26);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.button2 = (Button) findViewById(R.id.button2);
        this.textview7 = (TextView) findViewById(R.id.textview7);
        this.button3 = (Button) findViewById(R.id.button3);
        this.textview11 = (TextView) findViewById(R.id.textview11);
        this.button4 = (Button) findViewById(R.id.button4);
        this.UpdateIO_ReqNetwork = new RequestNetwork(this);
        this.UpdateIO_Dialog = new Builder(this);
        this.dlg = new Builder(this);
        this.sp = getSharedPreferences("ss", 0);
        this.error_dlg = new Builder(this);
        this.wa_list = new Builder(this);
        this.imageview1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.dlg.setTitle("WhatsApp Auswählen");
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setLayoutParams(new LayoutParams(-2, -2));
                linearLayout.setOrientation(1);
                final EditText editText = new EditText(MainActivity.this);
                editText.setText(MainActivity.this.sp.getString("name", ""));
                editText.setHint("com.fmwhatsapp");
                editText.setBackgroundColor(-1);
                editText.setLayoutParams(new LayoutParams(-1, -2));
                linearLayout.addView(editText);
                MainActivity.this.dlg.setView(linearLayout);
                MainActivity.this.dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        editText.getText().toString();
                        MainActivity.this.sp.edit().putString("name", editText.getText().toString()).commit();
                    }
                });
                MainActivity.this.dlg.setNegativeButton("ABBRECHEN", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                MainActivity.this.dlg.setNeutralButton("WA-LISTE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.wa_list.setTitle("WhatsApp (Mod) Liste");
                        MainActivity.this.wa_list.setMessage("Falsche Packet-Namen können zum Fehler führen.\n\nWhatsApp:\n„com.whatsapp“\n\nYoWhatsApp:\n„com.yowhatsapp“ or „com.wa“\n\nFMWhatsApp:\n„com.fmwhatsapp“ or „com.wa“\n\nGBWhatsApp:\n„com.gbwhatsapp“ or „com.wa“");
                        MainActivity.this.wa_list.setNegativeButton("FERTIG", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.this.dlg.setTitle("WhatsApp Auswählen");
                                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                                linearLayout.setLayoutParams(new LayoutParams(-2, -2));
                                linearLayout.setOrientation(1);
                                final EditText editText = new EditText(MainActivity.this);
                                editText.setText(MainActivity.this.sp.getString("name", ""));
                                editText.setHint("com.fmwhatsapp");
                                editText.setBackgroundColor(-1);
                                editText.setLayoutParams(new LayoutParams(-1, -2));
                                linearLayout.addView(editText);
                                MainActivity.this.dlg.setView(linearLayout);
                                MainActivity.this.dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        editText.getText().toString();
                                        MainActivity.this.sp.edit().putString("name", editText.getText().toString()).commit();
                                    }
                                });
                                MainActivity.this.dlg.setNegativeButton("ABBRECHEN", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                MainActivity.this.dlg.create().show();
                            }
                        });
                        MainActivity.this.wa_list.create().show();
                    }
                });
                MainActivity.this.dlg.create().show();
                MainActivity.this._round_corner(MainActivity.this.imageview1, 0.0d, "00000000");
            }
        });
        this.new_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.prefix.getText().toString().equals("+XXX") || MainActivity.this.character.getText().toString().equals("XX")) {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Wählen einen Landestyp");
                } else {
                    MainActivity.this._randomLetterGen(Double.parseDouble(MainActivity.this.character.getText().toString()), MainActivity.this.textview2);
                }
            }
        });
        this.button5.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.textview2.getText().toString().equals("Keine Nummer")) {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Es wurde keine Nummer generiert");
                } else {
                    MainActivity.this._WhatsAppSender(MainActivity.this.textview2.getText().toString(), "");
                }
            }
        });
        this.edittext1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.edittext1.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                if (4 < charSequence2.length() && MainActivity.this.prefix.getText().toString().equals("+49")) {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Benutze nur 3 bis 4 Zahlen (+49)");
                }
                if (2 < charSequence2.length() && MainActivity.this.prefix.getText().toString().equals("+41")) {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Benutze nur 2 Zahlen (+41)");
                }
                if (4 < charSequence2.length() && MainActivity.this.prefix.getText().toString().equals("+43")) {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Benutze nur 3 bis 4 Zahlen (+43)");
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.character.setText("7");
                MainActivity.this.prefix.setText("+49");
                MainActivity.this.edittext1.setText("1515");
            }
        });
        this.button3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.character.setText("7");
                MainActivity.this.prefix.setText("+41");
                MainActivity.this.edittext1.setText("37");
            }
        });
        this.button4.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.prefix.setText("+43");
                MainActivity.this.character.setText("7");
                MainActivity.this.edittext1.setText("409");
            }
        });
        this._UpdateIO_ReqNetwork_request_listener = new RequestListener() {
            public void onResponse(String str, String str2) {
                MainActivity.this.CurrentVersion = "0";
                try {
                    MainActivity.this.CurrentVersion = MainActivity.this.getPackageManager().getPackageInfo(MainActivity.this.getPackageName(), 0).versionName;
                } catch (Exception e) {
                }
                MainActivity.this.UpdateIO_Map = (HashMap) new Gson().fromJson(str2, new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (!MainActivity.this.UpdateIO_Map.get("app_new_version").toString().equals(MainActivity.this.CurrentVersion)) {
                    MainActivity.this.UpdateIO_Dialog.setCancelable(false);
                    MainActivity.this.UpdateIO_Dialog.setTitle(MainActivity.this.UpdateIO_Map.get("update_title").toString());
                    MainActivity.this.UpdateIO_Dialog.setMessage(MainActivity.this.UpdateIO_Map.get("update_description").toString());
                    MainActivity.this.UpdateIO_Dialog.setPositiveButton("AKTUALISIEREN", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.this.UpdateIO_Intent.setAction("android.intent.action.VIEW");
                            MainActivity.this.UpdateIO_Intent.setData(Uri.parse(MainActivity.this.UpdateIO_Map.get("update_download").toString()));
                            MainActivity.this.startActivity(MainActivity.this.UpdateIO_Intent);
                        }
                    });
                    MainActivity.this.UpdateIO_Dialog.setNegativeButton("ABBRECHEN", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.this.finish();
                        }
                    });
                    MainActivity.this.UpdateIO_Dialog.create().show();
                }
            }

            public void onErrorResponse(String str, String str2) {
                SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), str2);
            }
        };
    }

    private void initializeLogic() {
        _styles();
        _DarkMode();
        this.UpdateIO_ReqNetwork.startRequestNetwork(RequestNetworkController.GET, "https://api.myjson.com/bins/m7evk", "", this._UpdateIO_ReqNetwork_request_listener);
        _Add_long_click_on(this.button5);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void _randomLetterGen(double d, TextView textView) {
        this.letters.add("1");
        this.letters.add("2");
        this.letters.add("3");
        this.letters.add("4");
        this.letters.add("5");
        this.letters.add("6");
        this.letters.add("7");
        this.letters.add("8");
        this.letters.add("9");
        this.letters.add("0");
        this.randgetbackstr = "";
        for (int i = 0; i < ((int) d); i++) {
            if (SketchwareUtil.getRandom(0, 1) == 0) {
                this.doNotUseThisForSth = ((String) this.letters.get(SketchwareUtil.getRandom(0, this.letters.size() - 1))).toLowerCase();
            } else {
                this.doNotUseThisForSth = ((String) this.letters.get(SketchwareUtil.getRandom(0, this.letters.size() - 1))).toUpperCase();
            }
            this.randgetbackstr = this.randgetbackstr.concat(this.doNotUseThisForSth);
        }
        textView.setText(this.prefix.getText().toString().concat(this.edittext1.getText().toString()).concat(this.randgetbackstr));
    }

    private void _setError(View view, String str) {
        try {
            ((TextView) view).setError(str);
        } catch (Exception e) {
            showMessage(e.toString());
        }
    }

    private void _WhatsAppSender(String str, String str2) {
        if (this.sp.getString("name", "").equals("")) {
            this.error_dlg.setTitle("Fehler beim öffnen");
            this.error_dlg.setMessage("Bitte lege einen „Packet“ fest!\n(Rot markiertes icon in der ActionBar)");
            this.error_dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.error_dlg.create().show();
            _round_corner(this.imageview1, 100.0d, "D50000");
            return;
        }
        this.i.setAction("android.intent.action.VIEW");
        this.i.setData(Uri.parse("https://wa.me/".concat(str)));
        this.i.setPackage(this.sp.getString("name", ""));
        startActivity(this.i);
    }

    private void _Add_long_click_on(View view) {
        view.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                MainActivity mainActivity = MainActivity.this;
                MainActivity.this.getApplicationContext();
                ((ClipboardManager) mainActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", "https://wa.me/".concat(MainActivity.this.textview2.getText().toString())));
                return true;
            }
        });
    }

    private void _styles() {
        _round_corner(this.new_btn, 100.0d, "272727");
        _round_corner(this.button2, 100.0d, "272727");
        _round_corner(this.button3, 100.0d, "272727");
        _round_corner(this.button4, 100.0d, "272727");
        _round_corner(this.main, 28.0d, "FFFFFF");
        _round_corner(this.edittext1, 100.0d, "EEEEEE");
        _round_corner(this.button5, 100.0d, "272727");
        _NavStatusBarColor("202020", "272727");
    }

    private void _round_corner(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str));
        gradientDrawable.setCornerRadius(new Float(d).floatValue());
        view.setBackground(gradientDrawable);
    }

    private void _DarkMode() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            _round_corner(this.main, 28.0d, "202020");
            this.textview2.setTextColor(-1);
            this.prefix.setTextColor(-1);
            this.edittext1.setTextColor(-1);
            this.character.setTextColor(-1);
            this.textview3.setTextColor(-1);
            this.textview7.setTextColor(-1);
            this.textview8.setTextColor(-1);
            this.textview10.setTextColor(-1);
            this.textview11.setTextColor(-1);
            _round_corner(this.button4, 100.0d, "3D3E3F");
            _round_corner(this.new_btn, 100.0d, "3D3E3F");
            _round_corner(this.button2, 100.0d, "3D3E3F");
            _round_corner(this.edittext1, 100.0d, "3D3E3F");
            _round_corner(this.button5, 100.0d, "3D3E3F");
            _round_corner(this.button3, 100.0d, "3D3E3F");
        }
    }

    private void _NavStatusBarColor(String str, String str2) {
        if (VERSION.SDK_INT > 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#" + str.replace("#", "")));
            window.setNavigationBarColor(Color.parseColor("#" + str2.replace("#", "")));
        }
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList arrayList = new ArrayList();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
