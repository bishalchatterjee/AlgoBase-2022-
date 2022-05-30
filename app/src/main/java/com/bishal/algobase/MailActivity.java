package com.bishal.algobase;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailActivity extends AppCompatActivity {
    TextView feedback_title;
    TextView feedback_email;
    EditText feedback_content;
    Button send_Btn;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        feedback_title=findViewById(R.id.feedback_title);
        feedback_email=findViewById(R.id.feedback_email);
        feedback_content=findViewById(R.id.feedback_content);
        send_Btn=findViewById(R.id.send_Btn);


        //lottie animation declaration
        animationView = findViewById(R.id.animation_view);
        animationView.setVisibility(View.GONE);


        //using javax api to send mail in app without opening gmail
        send_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MailActivity.this, "Processing Feedback!", Toast.LENGTH_SHORT).show();
                //lottie animation trigger
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();
                final String username = "appprojectalgobase@gmail.com";
                final String password = "algobase";
                String messageToSend = feedback_content.getText().toString();
                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");//SMTP host is Gmail
                    props.put("mail.smtp.port", "587");//port for sending mail
                    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress((username)));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(feedback_email.getText().toString()));
//                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("appprojectalgobase@gmail"));
                        message.setSubject("AlgoBase Feedback");
                        message.setText(messageToSend);
                        Transport.send(message);
                        Toast.makeText(MailActivity.this, "Feedback Sent!", Toast.LENGTH_SHORT).show();
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }

                }
        });

        StrictMode.ThreadPolicy policy =new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}