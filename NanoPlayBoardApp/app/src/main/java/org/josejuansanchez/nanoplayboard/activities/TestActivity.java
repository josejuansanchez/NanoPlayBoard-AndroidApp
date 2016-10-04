package org.josejuansanchez.nanoplayboard.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.josejuansanchez.nanoplayboard.R;
import org.josejuansanchez.nanoplayboard.constants.ProtocolConstants;
import org.josejuansanchez.nanoplayboard.models.NanoPlayBoardMessage;

import tr.xip.markview.MarkView;

public class TestActivity extends NanoPlayBoardActivity {

    public static final String TAG = PotentiometerActivity.class.getSimpleName();
    private MarkView mMarkViewLdr;
    private Button mButtonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ldr);
        setTitle("LDR");
        mMarkViewLdr = (MarkView) findViewById(R.id.mark_ldr);
        mButtonStart = (Button) findViewById(R.id.button_start);
        loadListeners();
    }

    private void loadListeners() {
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendJsonMessage(ProtocolConstants.ID_LDR_READ);
            }
        });
    }

    @Override
    public void onUsbSerialMessage(NanoPlayBoardMessage message) {
        mMarkViewLdr.setMark(message.getLdr());
    }

    @Override
    public void onBluetoothMessage(NanoPlayBoardMessage message) {
        mMarkViewLdr.setMark(message.getLdr());
    }
}