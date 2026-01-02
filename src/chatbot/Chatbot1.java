package chatbot;

import commons.UIUtils;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Chatbot1 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Chatbot1.class.getName());
   
    public Chatbot1() {
        setUndecorated(true);  
        initComponents();
        FullScreen();
        
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
    
    /* FOR EVENTS */
    
    private void MouseEntered(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(179, 250, 160));
        label.setCursor(new Cursor(Cursor. HAND_CURSOR));
    }
    
    private void MouseExited(JLabel label){
        label.setOpaque(false);
        label.repaint();
        label.setBackground(new Color(242,242,242));
        label.setCursor(new Cursor(Cursor. DEFAULT_CURSOR));
        
    }
    
    // ============================================================================================================================

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        ChatHeader = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        closeBtn = new javax.swing.JLabel();
        minimizeBtn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
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
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChatHeader.setBackground(new java.awt.Color(53, 48, 128));
        ChatHeader.setMaximumSize(new java.awt.Dimension(32767, 77));
        ChatHeader.setMinimumSize(new java.awt.Dimension(100, 77));
        ChatHeader.setPreferredSize(new java.awt.Dimension(1520, 77));
        ChatHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 176, 200));
        jLabel2.setText("Healthy Lifestyle Chat");
        ChatHeader.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, -1));

        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/close-button.png"))); // NOI18N
        closeBtn.setIconTextGap(0);
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtnMouseExited(evt);
            }
        });
        ChatHeader.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 20, -1, -1));

        minimizeBtn.setForeground(new java.awt.Color(255, 255, 255));
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/minimize-button.png"))); // NOI18N
        minimizeBtn.setIconTextGap(0);
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseExited(evt);
            }
        });
        ChatHeader.add(minimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1810, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 238, 248));
        jLabel4.setText("SIMPLE CHATBOT");
        ChatHeader.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/back-button.png"))); // NOI18N
        backBtn.setIconTextGap(0);
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
        });
        ChatHeader.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 20, -1, -1));

        mainPanel.add(ChatHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

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
        btnResetConvo.addActionListener(this::btnResetConvoActionPerformed);
        Cpanel.add(btnResetConvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 887, -1, -1));
        btnResetConvo.getAccessibleContext().setAccessibleDescription("");

        jScrollPane1.setBackground(new java.awt.Color(53, 48, 128));
        jScrollPane1.setBorder(null);

        ChatAreaPanel.setBackground(new java.awt.Color(53, 48, 128));
        ChatAreaPanel.setBorder(null);
        ChatAreaPanel.setFocusable(false);
        ChatAreaPanel.setHighlighter(null);
        ChatAreaPanel.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(ChatAreaPanel);

        Cpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1164, 746));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatbot/ChatbotImages/chatbot (2).png"))); // NOI18N
        Cpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 970));

        mainPanel.add(Cpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1200, 950));

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

        Q6btn.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
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

        mainPanel.add(BtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 100, 640, 950));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// ============================================================================================================================        
    
    private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
        MouseEntered(closeBtn);
    }//GEN-LAST:event_closeBtnMouseEntered

    private void closeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseExited
        MouseExited(closeBtn);
    }//GEN-LAST:event_closeBtnMouseExited

    private void minimizeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseEntered
        MouseEntered(minimizeBtn);
    }//GEN-LAST:event_minimizeBtnMouseEntered

    private void minimizeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseExited
        MouseExited(minimizeBtn);
    }//GEN-LAST:event_minimizeBtnMouseExited

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        MouseEntered(backBtn);
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        MouseExited(backBtn);
    }//GEN-LAST:event_backBtnMouseExited

    
    private void minimizeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseClicked
        UIUtils.minimizeFrame(this);
    }//GEN-LAST:event_minimizeBtnMouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        // GO BACK TO DASBOARD
        // NOT YET DONE
    }//GEN-LAST:event_backBtnMouseClicked

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

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
       UIUtils.closeFrame(this, "Are you sure you want to exit? Your conversation will be lost.", "Warning", JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_closeBtnMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new Chatbot1().setVisible(true));
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
    private javax.swing.JLabel backBtn;
    private commons.GradientButton btnResetConvo;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel minimizeBtn;
    // End of variables declaration//GEN-END:variables
}
