package chatbot;

import commons.NavigationUtil;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Chatbot1 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Chatbot1.class.getName());
    private JFrame parent;
    
    public Chatbot1(JFrame parent) {
        setUndecorated(true);  
        initComponents();
        FullScreen();
        this.parent = parent;       
        ChatAreaPanel.setEditable(false);
        
    }
    
    private void FullScreen(){
        this.setExtendedState(JFrame. MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private void appendChat(String sender, String message) {
    StyledDocument doc = ChatAreaPanel.getStyledDocument();

    SimpleAttributeSet senderStyle = new SimpleAttributeSet();
    StyleConstants.setBold(senderStyle, true);
    StyleConstants.setFontFamily(senderStyle, "Montserrat");
    StyleConstants.setFontSize(senderStyle, 18);
    StyleConstants.setForeground(senderStyle,
            sender.equals("User") ? new Color(180, 220, 255) : new Color(255, 180, 255));

    SimpleAttributeSet msgStyle = new SimpleAttributeSet();
    StyleConstants.setFontFamily(msgStyle, "Montserrat");
    StyleConstants.setFontSize(msgStyle, 17);
    StyleConstants.setForeground(msgStyle, Color.WHITE);

    try {
        doc.insertString(doc.getLength(), sender + ": ", senderStyle);
        doc.insertString(doc.getLength(), message + "\n\n", msgStyle);
        ChatAreaPanel.setCaretPosition(doc.getLength());
    } catch (BadLocationException e) {}
}
    
    private void handleLabelClick(JLabel label, String question, String answer) {
    if (!label.isEnabled()) return;

    appendChat("User", question);
    appendChat("Hetty", answer);

    label.setEnabled(false);                 
    label.setForeground(new Color(255,255,255));
    label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
}


    
    // ============================================================================================================================

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        ChatHeader = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnExit = new commons.RoundButton();
        btnMinimize = new commons.RoundButton();
        btnBack = new commons.RoundButton();
        Cpanel = new javax.swing.JPanel();
        btnResetConvo = new commons.GradientButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ChatAreaPanel = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        BtnPanel = new javax.swing.JPanel();
        Q1btn1 = new javax.swing.JLabel();
        Q1btn = new javax.swing.JLabel();
        Q2btn = new javax.swing.JLabel();
        Q3btn = new javax.swing.JLabel();
        Q4btn = new javax.swing.JLabel();
        Q5btn = new javax.swing.JLabel();
        Q6btn = new javax.swing.JLabel();
        Q7btn = new javax.swing.JLabel();
        Q8btn = new javax.swing.JLabel();
        Q9btn = new javax.swing.JLabel();
        Q10btn = new javax.swing.JLabel();
        Q11btn = new javax.swing.JLabel();
        Q12btn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(14, 22, 48));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(14, 22, 48));

        ChatHeader.setBackground(new java.awt.Color(53, 48, 128));
        ChatHeader.setMaximumSize(new java.awt.Dimension(32767, 77));
        ChatHeader.setMinimumSize(new java.awt.Dimension(100, 77));
        ChatHeader.setPreferredSize(new java.awt.Dimension(1520, 77));
        ChatHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 176, 200));
        jLabel2.setText("Healthy Lifestyle Chat");
        ChatHeader.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 238, 248));
        jLabel4.setText("SIMPLE CHATBOT");
        ChatHeader.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnExit.setBackground(new java.awt.Color(219, 60, 172));
        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("x");
        btnExit.setBorderColor(new java.awt.Color(219, 60, 172));
        btnExit.setBorderEnabled(false);
        btnExit.setBorderPainted(false);
        btnExit.setColor(new java.awt.Color(219, 60, 172));
        btnExit.setColorClick(new java.awt.Color(153, 62, 145));
        btnExit.setColorOver(new java.awt.Color(153, 62, 145));
        btnExit.setFocusable(false);
        btnExit.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        btnExit.setRadius(10);
        btnExit.addActionListener(this::btnExitActionPerformed);
        ChatHeader.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1853, 18, 40, 39));

        btnMinimize.setBorder(null);
        btnMinimize.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimize.setText("–");
        btnMinimize.setBorderColor(new java.awt.Color(75, 74, 151));
        btnMinimize.setBorderEnabled(false);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setColor(new java.awt.Color(75, 74, 151));
        btnMinimize.setColorClick(new java.awt.Color(48, 43, 116));
        btnMinimize.setColorOver(new java.awt.Color(48, 43, 116));
        btnMinimize.setFocusable(false);
        btnMinimize.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        btnMinimize.setRadius(10);
        btnMinimize.addActionListener(this::btnMinimizeActionPerformed);
        ChatHeader.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1801, 18, 40, 39));

        btnBack.setBorder(null);
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.setBorderColor(new java.awt.Color(75, 74, 151));
        btnBack.setBorderEnabled(false);
        btnBack.setBorderPainted(false);
        btnBack.setColor(new java.awt.Color(75, 74, 151));
        btnBack.setColorClick(new java.awt.Color(48, 43, 116));
        btnBack.setColorOver(new java.awt.Color(48, 43, 116));
        btnBack.setFocusable(false);
        btnBack.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        btnBack.setRadius(10);
        btnBack.addActionListener(this::btnBackActionPerformed);
        ChatHeader.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1653, 18, 136, 39));

        Cpanel.setBackground(new java.awt.Color(14, 22, 48));
        Cpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnResetConvo.setText("Reset Conversation");
        btnResetConvo.setColor1(new java.awt.Color(109, 31, 239));
        btnResetConvo.setColor2(new java.awt.Color(234, 46, 201));
        btnResetConvo.setFocusable(false);
        btnResetConvo.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        btnResetConvo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnResetConvo.setHoverColor1(new java.awt.Color(158, 100, 255));
        btnResetConvo.setHoverColor2(new java.awt.Color(244, 105, 220));
        btnResetConvo.setSizeSpeed(1000.0F);
        btnResetConvo.addActionListener(this::btnResetConvoActionPerformed);
        Cpanel.add(btnResetConvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 870, -1, -1));
        btnResetConvo.getAccessibleContext().setAccessibleDescription("");

        jScrollPane1.setBackground(new java.awt.Color(53, 48, 128));
        jScrollPane1.setBorder(null);

        ChatAreaPanel.setBackground(new java.awt.Color(53, 48, 128));
        ChatAreaPanel.setBorder(null);
        ChatAreaPanel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        ChatAreaPanel.setFocusable(false);
        ChatAreaPanel.setHighlighter(null);
        ChatAreaPanel.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(ChatAreaPanel);

        Cpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1164, 746));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbot (2).png"))); // NOI18N
        Cpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 970));

        BtnPanel.setBackground(new java.awt.Color(14, 22, 48));
        BtnPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 23));

        Q1btn1.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        Q1btn1.setForeground(new java.awt.Color(255, 255, 255));
        Q1btn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Q1btn1.setText("Healthy Lifestyle Chatbot: Guide Questions");
        Q1btn1.setToolTipText("");
        Q1btn1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Q1btn1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BtnPanel.add(Q1btn1);

        Q1btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q1btn.setForeground(new java.awt.Color(255, 255, 255));
        Q1btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q1btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        Q1btn.setText("Ano ang ibig sabihin ng malusog na pamumuhay?");
        Q1btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q1btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q1btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q1btn);

        Q2btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q2btn.setForeground(new java.awt.Color(255, 255, 255));
        Q2btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q2btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        Q2btn.setText("Bakit mahalaga ang regular na ehersisyo?");
        Q2btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q2btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q2btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q2btn);

        Q3btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q3btn.setForeground(new java.awt.Color(255, 255, 255));
        Q3btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q3btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        Q3btn.setText("Ilang oras ng tulog ang kailangan ng isang adult?");
        Q3btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q3btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q3btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q3btn);

        Q4btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q4btn.setForeground(new java.awt.Color(255, 255, 255));
        Q4btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q4btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        Q4btn.setText("Paano nakaaapekto ang stress sa kalusugan?");
        Q4btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q4btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q4btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q4btn);

        Q5btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q5btn.setForeground(new java.awt.Color(255, 255, 255));
        Q5btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q5btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        Q5btn.setText("Isang simpleng habit para sa healthy lifestyle?");
        Q5btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q5btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q5btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q5btn);

        Q6btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q6btn.setForeground(new java.awt.Color(255, 255, 255));
        Q6btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q6btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        Q6btn.setText("Ano ang benepisyo ng balanseng pagkain?");
        Q6btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q6btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q6btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q6btn);

        Q7btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q7btn.setForeground(new java.awt.Color(255, 255, 255));
        Q7btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q7btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbtn (1).png"))); // NOI18N
        Q7btn.setText("Ilang minuto ng ehersisyo ang nirerekomenda bawat araw?");
        Q7btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q7btn.setMaximumSize(new java.awt.Dimension(600, 50));
        Q7btn.setMinimumSize(new java.awt.Dimension(600, 50));
        Q7btn.setPreferredSize(new java.awt.Dimension(600, 50));
        Q7btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q7btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q7btn);

        Q8btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q8btn.setForeground(new java.awt.Color(255, 255, 255));
        Q8btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q8btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbtn (1).png"))); // NOI18N
        Q8btn.setText("Bakit mahalagang uminom ng sapat na tubig araw-araw?");
        Q8btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q8btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q8btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q8btn);

        Q9btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q9btn.setForeground(new java.awt.Color(255, 255, 255));
        Q9btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q9btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbtn (1).png"))); // NOI18N
        Q9btn.setText("Ano ang mga healthy na paraan para ma-manage ang stress?");
        Q9btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q9btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q9btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q9btn);

        Q10btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q10btn.setForeground(new java.awt.Color(255, 255, 255));
        Q10btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q10btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbtn (1).png"))); // NOI18N
        Q10btn.setText("Bakit dapat bawasan ang matatamis at processed foods?");
        Q10btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q10btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q10btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q10btn);

        Q11btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q11btn.setForeground(new java.awt.Color(255, 255, 255));
        Q11btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q11btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbtn (1).png"))); // NOI18N
        Q11btn.setText("Paano konektado ang mental health sa healthy lifestyle?");
        Q11btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q11btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q11btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q11btn);

        Q12btn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Q12btn.setForeground(new java.awt.Color(255, 255, 255));
        Q12btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q12btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbtn (1).png"))); // NOI18N
        Q12btn.setText("Bakit mahalagang iwasan ang paninigarilyo at labis na alak?");
        Q12btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Q12btn.setMaximumSize(new java.awt.Dimension(600, 50));
        Q12btn.setMinimumSize(new java.awt.Dimension(600, 50));
        Q12btn.setPreferredSize(new java.awt.Dimension(600, 50));
        Q12btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Q12btnMouseClicked(evt);
            }
        });
        BtnPanel.add(Q12btn);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChatHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Cpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(ChatHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnResetConvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetConvoActionPerformed
    
    ChatAreaPanel.setText("");

    JLabel[] labels = {
        Q1btn, Q2btn, Q3btn, Q4btn, Q5btn, Q6btn,
        Q7btn, Q8btn, Q9btn, Q10btn, Q11btn, Q12btn
    };

    for (JLabel lbl : labels) {
        lbl.setEnabled(true);
        lbl.setForeground(Color.WHITE);
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    }//GEN-LAST:event_btnResetConvoActionPerformed

    private void Q1btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q1btnMouseClicked
    handleLabelClick(
            Q1btn,
            "Ano ang ibig sabihin ng malusog na pamumuhay?",
            "Ang malusog na pamumuhay ay tamang pagkain, ehersisyo, sapat na tulog, at pangangalaga sa mental health."
        );        
    }//GEN-LAST:event_Q1btnMouseClicked

    private void Q2btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q2btnMouseClicked
     handleLabelClick(
        Q2btn,
        "Bakit mahalaga ang regular na ehersisyo?",
        "Pinapalakas nito ang katawan, pinapabuti ang puso, at nakatutulong sa mental na kalusugan."
    );  
    }//GEN-LAST:event_Q2btnMouseClicked

    private void Q3btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q3btnMouseClicked
    handleLabelClick(
        Q3btn,
        "Ilang oras ng tulog ang kailangan ng isang adult?",
        "Kailangan ng 7–9 oras ng tulog bawat gabi para sa maayos na kalusugan."
    );   // TODO add your handling code here:
    }//GEN-LAST:event_Q3btnMouseClicked

    private void Q4btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q4btnMouseClicked
    handleLabelClick(
        Q4btn,
        "Paano nakaaapekto ang stress sa kalusugan?",
        "Ang labis na stress ay maaaring magdulot ng pagkapagod, sakit, at problema sa mental health."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q4btnMouseClicked

    private void Q5btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q5btnMouseClicked
    handleLabelClick(
        Q5btn,
        "Isang simpleng habit para sa healthy lifestyle?",
        "Uminom ng sapat na tubig at gumalaw kahit 30 minuto araw-araw."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q5btnMouseClicked

    private void Q6btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q6btnMouseClicked
     handleLabelClick(
        Q6btn,
        "Ano ang benepisyo ng balanseng pagkain?",
        "Nagbibigay ito ng sapat na nutrisyon, lakas ng katawan, at proteksyon laban sa sakit."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q6btnMouseClicked

    private void Q7btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q7btnMouseClicked
      handleLabelClick(
        Q7btn,
        "Ilang minuto ng ehersisyo ang nirerekomenda bawat araw?",
        "Inirerekomenda ang hindi bababa sa 30 minuto ng ehersisyo araw-araw."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q7btnMouseClicked

    private void Q8btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q8btnMouseClicked
    handleLabelClick(
        Q8btn,
        "Bakit mahalagang uminom ng sapat na tubig araw-araw?",
        "Tumutulong ang tubig sa digestion, sirkulasyon, at tamang paggana ng katawan."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q8btnMouseClicked

    private void Q9btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q9btnMouseClicked
      handleLabelClick(
        Q9btn,
        "Ano ang mga healthy na paraan para ma-manage ang stress?",
        "Ehersisyo, tamang pahinga, paghinga nang malalim, at pakikipag-usap sa iba."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q9btnMouseClicked

    private void Q10btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q10btnMouseClicked
    handleLabelClick(
        Q10btn,
        "Bakit dapat bawasan ang matatamis at processed foods?",
        "Maaari itong magdulot ng obesity, diabetes, at iba pang sakit."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q10btnMouseClicked

    private void Q11btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q11btnMouseClicked
     handleLabelClick(
        Q11btn,
        "Paano konektado ang mental health sa healthy lifestyle?",
        "Ang mabuting mental health ay tumutulong sa tamang desisyon at pangangalaga sa katawan."
    );    // TODO add your handling code here:
    }//GEN-LAST:event_Q11btnMouseClicked

    private void Q12btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Q12btnMouseClicked
    handleLabelClick(
        Q12btn,
        "Bakit mahalagang iwasan ang paninigarilyo at labis na alak?",
        "Nakasasama ito sa baga, atay, puso, at pangkalahatang kalusugan."
    );        // TODO add your handling code here:
    }//GEN-LAST:event_Q12btnMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        NavigationUtil.switchFrame(this, parent);
    }//GEN-LAST:event_btnBackActionPerformed

// ============================================================================================================================    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> new Chatbot1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnPanel;
    private javax.swing.JTextPane ChatAreaPanel;
    private javax.swing.JPanel ChatHeader;
    private javax.swing.JPanel Cpanel;
    private javax.swing.JLabel Q10btn;
    private javax.swing.JLabel Q11btn;
    private javax.swing.JLabel Q12btn;
    private javax.swing.JLabel Q1btn;
    private javax.swing.JLabel Q1btn1;
    private javax.swing.JLabel Q2btn;
    private javax.swing.JLabel Q3btn;
    private javax.swing.JLabel Q4btn;
    private javax.swing.JLabel Q5btn;
    private javax.swing.JLabel Q6btn;
    private javax.swing.JLabel Q7btn;
    private javax.swing.JLabel Q8btn;
    private javax.swing.JLabel Q9btn;
    private commons.RoundButton btnBack;
    private commons.RoundButton btnExit;
    private commons.RoundButton btnMinimize;
    private commons.GradientButton btnResetConvo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
