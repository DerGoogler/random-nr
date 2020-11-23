package com.dg.random.nr;

import android.app.Activity;

public class DebugActivity extends Activity {
    String[] errMessage = new String[]{"Invalid string operation\n", "Invalid list operation\n", "Invalid arithmetical operation\n", "Invalid toNumber block operation\n", "Invalid intent operation"};
    String[] exceptionType = new String[]{"StringIndexOutOfBoundsException", "IndexOutOfBoundsException", "ArithmeticException", "NumberFormatException", "ActivityNotFoundException"};

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:7:0x0023, code skipped:
            if (r1.isEmpty() != false) goto L_0x0025;
     */
    public void onCreate(android.os.Bundle r8) {
        /*
        r7 = this;
        r2 = 0;
        super.onCreate(r8);
        r0 = r7.getIntent();
        r1 = "";
        r1 = "";
        if (r0 == 0) goto L_0x008f;
    L_0x000e:
        r3 = "error";
        r0 = r0.getStringExtra(r3);
        r3 = "\n";
        r3 = r0.split(r3);
    L_0x001a:
        r4 = r7.exceptionType;	 Catch:{ Exception -> 0x008c }
        r4 = r4.length;	 Catch:{ Exception -> 0x008c }
        if (r2 < r4) goto L_0x0044;
    L_0x001f:
        r2 = r1.isEmpty();	 Catch:{ Exception -> 0x008c }
        if (r2 == 0) goto L_0x008f;
    L_0x0025:
        r1 = new android.app.AlertDialog$Builder;
        r1.<init>(r7);
        r2 = "An error occured";
        r1.setTitle(r2);
        r1.setMessage(r0);
        r0 = "End Application";
        r2 = new com.dg.random.nr.DebugActivity$1;
        r2.<init>();
        r1.setNeutralButton(r0, r2);
        r0 = r1.create();
        r0.show();
        return;
    L_0x0044:
        r4 = 0;
        r4 = r3[r4];	 Catch:{ Exception -> 0x008c }
        r5 = r7.exceptionType;	 Catch:{ Exception -> 0x008c }
        r5 = r5[r2];	 Catch:{ Exception -> 0x008c }
        r4 = r4.contains(r5);	 Catch:{ Exception -> 0x008c }
        if (r4 == 0) goto L_0x0089;
    L_0x0051:
        r4 = r7.errMessage;	 Catch:{ Exception -> 0x008c }
        r1 = r4[r2];	 Catch:{ Exception -> 0x008c }
        r4 = 0;
        r4 = r3[r4];	 Catch:{ Exception -> 0x008c }
        r5 = r7.exceptionType;	 Catch:{ Exception -> 0x008c }
        r5 = r5[r2];	 Catch:{ Exception -> 0x008c }
        r4 = r4.indexOf(r5);	 Catch:{ Exception -> 0x008c }
        r5 = r7.exceptionType;	 Catch:{ Exception -> 0x008c }
        r2 = r5[r2];	 Catch:{ Exception -> 0x008c }
        r2 = r2.length();	 Catch:{ Exception -> 0x008c }
        r2 = r2 + r4;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008c }
        r5 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x008c }
        r4.<init>(r5);	 Catch:{ Exception -> 0x008c }
        r5 = 0;
        r5 = r3[r5];	 Catch:{ Exception -> 0x008c }
        r6 = 0;
        r3 = r3[r6];	 Catch:{ Exception -> 0x008c }
        r3 = r3.length();	 Catch:{ Exception -> 0x008c }
        r2 = r5.substring(r2, r3);	 Catch:{ Exception -> 0x008c }
        r2 = r4.append(r2);	 Catch:{ Exception -> 0x008c }
        r1 = r2.toString();	 Catch:{ Exception -> 0x008c }
        goto L_0x001f;
    L_0x0089:
        r2 = r2 + 1;
        goto L_0x001a;
    L_0x008c:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0025;
    L_0x008f:
        r0 = r1;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dg.random.nr.DebugActivity.onCreate(android.os.Bundle):void");
    }
}
