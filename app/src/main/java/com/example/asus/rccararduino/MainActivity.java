package com.example.asus.rccararduino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;
public class MainActivity extends AppCompatActivity {
    private final String DEVICE_ADRESS = "98:D3:32:10:57:63";//change this code find th real adress for the bluetooth module

    private final UUID PORT_UUID=UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outputStream;

    Button forward_btn, backward_btn, left_btn, right_btn, connect_btn,left_signal,right_signal,headlight;
    String command;//string variable that will store value to be transmitted to the bluetooth module

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //declaration of button variables
        forward_btn = (Button) findViewById(R.id.forward_btn);
        backward_btn = (Button) findViewById(R.id.backward_btn);
        left_btn = (Button) findViewById(R.id.left_btn);
        right_btn = (Button) findViewById(R.id.right_btn);
        connect_btn = (Button) findViewById(R.id.connect_btn);
        left_signal = (Button) findViewById(R.id.left_signal);
        right_signal = (Button) findViewById(R.id.right_signal);
        headlight = (Button) findViewById(R.id.headlight);
        //**************************FORWARD BUTTON*************************
        //onTouchListener code for the forward button (button long press)
        forward_btn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    command = "1";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });

//*******************************BACKWARD BUTTON********************************
        //onTouchListener code for the backward button(button long press)
        backward_btn.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "2";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    command = "10";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();//this line may should be empty
                    }
                }
                return false;
            }


        });

        //*****************************TURN LEFT BUTTON*********************
        //onTouchListener code for the turn left button(button long press)

        left_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    command = "4";

                    try {
                        outputStream.write(command.getBytes());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
                return false;
            }
        });

        //*****************************TURN RIGHT BUTTON*********************
        //onTouchListener code for the rı left button(button long press)

        right_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    command = "3";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return false;
            }
        });

        //******************************LEFT SIGNAL BUTTON***************************************
        left_signal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    command = "5";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return false;
            }
        });

        //***********************RIGHT SIGNAL BUTTON**************************

        right_signal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    command = "6";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return false;
            }
        });

        //*****************************HEADLIGHT BUTTON*********************
        headlight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    command = "7";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return false;
            }
        });

        //*****************************CONNECT BUTTON*********************
        //Button that connects the device to the bluetooth module when pressed
        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (BTinit()) {
                    BTconnect();
                }
            }
        });
    }

    //Initializes bluetooth module
    public boolean BTinit() {
        boolean found = false;

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //check if the device supports bluetooth
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "Device doesn't support bluetooth", Toast.LENGTH_SHORT).show();

        }

        //checks if bluetooth is enable.If not,the program will ask permission from the user to enable
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter, 0);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Set<BluetoothDevice> boundedDevices = bluetoothAdapter.getBondedDevices();

        if (boundedDevices.isEmpty()) {

            Toast.makeText(getApplicationContext(), "please pair the device first", Toast.LENGTH_SHORT).show();

        } else {
            for (BluetoothDevice iterator : boundedDevices) {

                if (iterator.getAddress().equals(DEVICE_ADRESS)) {

                    device = iterator;
                    found = true;
                    break;
                }
            }

        }


        return found;
    }

    public boolean BTconnect() {

        boolean connected = true;

        try {
            //creates a socket to handle the outgoing connection
            socket = device.createInsecureRfcommSocketToServiceRecord(PORT_UUID);
            socket.connect();

            Toast.makeText(getApplicationContext(), "Connection to bluetooth device successful", Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
            connected = false;
        }

        if (connected) {
            try {
                outputStream = socket.getOutputStream();//gets the output stream of the socket
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return connected;
    }

    protected void onStart() {
        super.onStart();
    }
}

