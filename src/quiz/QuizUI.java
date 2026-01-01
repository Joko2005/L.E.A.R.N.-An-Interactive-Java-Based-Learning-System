package quiz;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuizUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(QuizUI.class.getName());

    /**
     * Creates new form QuizFrame
     */
    public QuizUI() {
        setUndecorated(true);  // ← MUST be BEFORE initComponents()
        initComponents();
        
        // Hide tabs
        contentsTabbedPane.setUI(new javax.swing. plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                return 0;
            }

            @Override
            protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
                // Don't paint tabs
            }
        });
        
        FullScreen();
        Tabs(startquizPanel); 
//        Tabs(resultPanel);
        QuizInstructions();
    }
    
    private void FullScreen(){
        this.setExtendedState(JFrame. MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private void QuizInstructions(){
        instructionsLbl.setText("<html>" +
            "<div style='width: 700px; font-family:  Poppins, SansSerif; font-size: 14px; color: #C3C9D9; line-height: 1.6;'>" +
            "• This quiz contains 17 multiple-choice questions, each with four (4) options and one correct answer. <br>" +
            "• The quiz is time-bound and will begin immediately after starting.<br>" +
            "• All questions must be answered; unanswered items will be marked incorrect.<br>" +
            "• Once submitted, answers cannot be modified. <br><br>" +

            "<b style='color: #E6EEF8; font-size: 16px;'>Results & Evaluation</b><br>" +
            "• A summary will display correct and incorrect responses per question.<br>" +
            "• Performance remarks will be given based on the final score: <br>" +
            "&nbsp;&nbsp;&nbsp;&nbsp;Excellent, Very Good, Fair, or Failed. <br>" +
            "• Personalized recommendations will be provided according to the score.<br><br>" +

            "<b style='color: #E6EEF8; font-size: 16px;'>Progress Monitoring</b><br>" +
            "• The system records quiz takers for progress tracking and result monitoring.<br><br>" +

            "Please ensure you are prepared before proceeding. <br><br>" +

            "Click <b style='color: #E6EEF8;'>\"Start Quiz\"</b> to begin." +
            "</div>" +
            "</html>");
        
        titleLbl.setText("Quiz Instructions");
    }
    
    private void StartQuiz(){
        Tabs(q1Panel);
    }
    
    private String Recommendation(double percentage) {
        if (percentage >= 90) {
            return "Outstanding performance! You have demonstrated exceptional understanding of the material.  " +
                   "Consider exploring advanced topics or mentoring others to reinforce your knowledge.";
        } else if (percentage >= 75) {
            return "Great job! You have a solid grasp of the concepts. " +
                   "Review the questions you missed to strengthen your understanding further.";
        } else if (percentage >= 60) {
            return "You passed, but there's room for improvement. " +
                   "Focus on reviewing the topics where you struggled and consider retaking the quiz after additional study.";
        } else {
            return "You did not pass this time. Don't be discouraged! " +
                   "Review all the material thoroughly, especially the questions you got wrong. " +
                   "Take your time to understand each concept before retaking the quiz.";
        }
    }
    
    private void Tabs(JPanel addThis){
        contentsTabbedPane.remove(startquizPanel);
        contentsTabbedPane.remove(q1Panel);
        contentsTabbedPane.remove(q2Panel);
        contentsTabbedPane.remove(q3Panel);
        contentsTabbedPane.remove(q4Panel);
        contentsTabbedPane.remove(q5Panel);
        contentsTabbedPane.remove(q6Panel);
        contentsTabbedPane.remove(q7Panel);
        contentsTabbedPane.remove(q8Panel);
        contentsTabbedPane.remove(q9Panel);
        contentsTabbedPane.remove(q10Panel);
        contentsTabbedPane.remove(q11Panel);
        contentsTabbedPane.remove(q12Panel);
        contentsTabbedPane.remove(q13Panel);
        contentsTabbedPane.remove(q14Panel);
        contentsTabbedPane.remove(q15Panel);
        contentsTabbedPane.remove(q16Panel);
        contentsTabbedPane.remove(q17Panel);
        contentsTabbedPane.remove(resultPanel);
        
        contentsTabbedPane.add(addThis);
    }
    
    // ============================================================================================================================

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        closeBtn = new javax.swing.JLabel();
        minimizeBtn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JLabel();
        contentsTabbedPane = new javax.swing.JTabbedPane();
        startquizPanel = new javax.swing.JPanel();
        instructionsLbl = new javax.swing.JLabel();
        startQuizBtn = new javax.swing.JLabel();
        q1Panel = new javax.swing.JPanel();
        next1Btn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        q2Panel = new javax.swing.JPanel();
        next2Btn = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        q3Panel = new javax.swing.JPanel();
        next3Btn = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        q4Panel = new javax.swing.JPanel();
        next4Btn = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        q5Panel = new javax.swing.JPanel();
        next5Btn = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        q6Panel = new javax.swing.JPanel();
        next6Btn = new javax.swing.JLabel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        q7Panel = new javax.swing.JPanel();
        next7Btn = new javax.swing.JLabel();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        q8Panel = new javax.swing.JPanel();
        next8Btn = new javax.swing.JLabel();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        q9Panel = new javax.swing.JPanel();
        next9Btn = new javax.swing.JLabel();
        jRadioButton33 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton36 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        q10Panel = new javax.swing.JPanel();
        next10Btn = new javax.swing.JLabel();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jRadioButton39 = new javax.swing.JRadioButton();
        jRadioButton40 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        q11Panel = new javax.swing.JPanel();
        next11Btn = new javax.swing.JLabel();
        jRadioButton41 = new javax.swing.JRadioButton();
        jRadioButton42 = new javax.swing.JRadioButton();
        jRadioButton43 = new javax.swing.JRadioButton();
        jRadioButton44 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        q12Panel = new javax.swing.JPanel();
        next12Btn = new javax.swing.JLabel();
        jRadioButton45 = new javax.swing.JRadioButton();
        jRadioButton46 = new javax.swing.JRadioButton();
        jRadioButton47 = new javax.swing.JRadioButton();
        jRadioButton48 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        q13Panel = new javax.swing.JPanel();
        next13Btn = new javax.swing.JLabel();
        jRadioButton49 = new javax.swing.JRadioButton();
        jRadioButton50 = new javax.swing.JRadioButton();
        jRadioButton51 = new javax.swing.JRadioButton();
        jRadioButton52 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        q14Panel = new javax.swing.JPanel();
        next14Btn = new javax.swing.JLabel();
        jRadioButton53 = new javax.swing.JRadioButton();
        jRadioButton54 = new javax.swing.JRadioButton();
        jRadioButton55 = new javax.swing.JRadioButton();
        jRadioButton56 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        q15Panel = new javax.swing.JPanel();
        next15Btn = new javax.swing.JLabel();
        jRadioButton57 = new javax.swing.JRadioButton();
        jRadioButton58 = new javax.swing.JRadioButton();
        jRadioButton59 = new javax.swing.JRadioButton();
        jRadioButton60 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        q16Panel = new javax.swing.JPanel();
        next16Btn = new javax.swing.JLabel();
        jRadioButton61 = new javax.swing.JRadioButton();
        jRadioButton62 = new javax.swing.JRadioButton();
        jRadioButton63 = new javax.swing.JRadioButton();
        jRadioButton64 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        q17Panel = new javax.swing.JPanel();
        next17Btn = new javax.swing.JLabel();
        jRadioButton65 = new javax.swing.JRadioButton();
        jRadioButton66 = new javax.swing.JRadioButton();
        jRadioButton67 = new javax.swing.JRadioButton();
        jRadioButton68 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        resultPanel = new javax.swing.JPanel();
        retakeQuizBtn = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        retakeQuizBtn2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        scoreLbl = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        percentageLbl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        remarkLbl1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        q17AnsLbl = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        q17EvalLbl = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        q1AnsLbl = new javax.swing.JLabel();
        q2AnsLbl = new javax.swing.JLabel();
        q3AnsLbl = new javax.swing.JLabel();
        q4AnsLbl = new javax.swing.JLabel();
        q5AnsLbl = new javax.swing.JLabel();
        q6AnsLbl = new javax.swing.JLabel();
        q7AnsLbl = new javax.swing.JLabel();
        q8AnsLbl = new javax.swing.JLabel();
        q9AnsLbl = new javax.swing.JLabel();
        q10AnsLbl = new javax.swing.JLabel();
        q11AnsLbl = new javax.swing.JLabel();
        q12AnsLbl = new javax.swing.JLabel();
        q13AnsLbl = new javax.swing.JLabel();
        q14AnsLbl = new javax.swing.JLabel();
        q15AnsLbl = new javax.swing.JLabel();
        q16AnsLbl = new javax.swing.JLabel();
        q1EvalLbl = new javax.swing.JLabel();
        q2EvalLbl = new javax.swing.JLabel();
        scoreLbl1 = new javax.swing.JLabel();
        q3EvalLbl = new javax.swing.JLabel();
        q4EvalLbl = new javax.swing.JLabel();
        q5EvalLbl = new javax.swing.JLabel();
        q6EvalLbl = new javax.swing.JLabel();
        q7EvalLbl = new javax.swing.JLabel();
        q8EvalLbl = new javax.swing.JLabel();
        q9EvalLbl = new javax.swing.JLabel();
        q10EvalLbl = new javax.swing.JLabel();
        q11EvalLbl = new javax.swing.JLabel();
        q12EvalLbl = new javax.swing.JLabel();
        q13EvalLbl = new javax.swing.JLabel();
        q14EvalLbl = new javax.swing.JLabel();
        q15EvalLbl = new javax.swing.JLabel();
        q16EvalLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        titleLbl = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(14, 22, 48));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(14, 22, 48));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(53, 48, 128));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 77));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 77));
        jPanel2.setPreferredSize(new java.awt.Dimension(1520, 77));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 176, 200));
        jLabel2.setText("History Quiz");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/close-button.png"))); // NOI18N
        closeBtn.setIconTextGap(0);
        jPanel2.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 20, -1, -1));

        minimizeBtn.setForeground(new java.awt.Color(255, 255, 255));
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/minimize-button.png"))); // NOI18N
        minimizeBtn.setIconTextGap(0);
        jPanel2.add(minimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1810, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 238, 248));
        jLabel4.setText("TAKE QUIZ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        backBtn1.setForeground(new java.awt.Color(255, 255, 255));
        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/back-button.png"))); // NOI18N
        backBtn1.setIconTextGap(0);
        jPanel2.add(backBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 20, -1, -1));

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        contentsTabbedPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        startquizPanel.setBackground(new java.awt.Color(53, 48, 128));
        startquizPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructionsLbl.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        instructionsLbl.setForeground(new java.awt.Color(255, 255, 255));
        instructionsLbl.setText("placeholder");
        startquizPanel.add(instructionsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        startQuizBtn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        startQuizBtn.setForeground(new java.awt.Color(255, 255, 255));
        startQuizBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        startQuizBtn.setText("START QUIZ");
        startQuizBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startquizPanel.add(startQuizBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        contentsTabbedPane.addTab("Start Quiz", startquizPanel);

        q1Panel.setBackground(new java.awt.Color(53, 48, 128));
        q1Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next1Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next1Btn.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next1Btn.setText("NEXT");
        next1Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q1Panel.add(next1Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("1. In what year did the Spanish expedition led by Ferdinand Magellan arrive in the Philippines?");
        q1Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText(" D. 1898");
        q1Panel.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton2.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText(" A. 1492");
        q1Panel.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jRadioButton3.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton3.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText(" B. 1521");
        q1Panel.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton4.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText(" C. 1565");
        q1Panel.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        contentsTabbedPane.addTab("Q1", q1Panel);

        q2Panel.setBackground(new java.awt.Color(53, 48, 128));
        q2Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next2Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next2Btn.setForeground(new java.awt.Color(255, 255, 255));
        next2Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next2Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next2Btn.setText("NEXT");
        next2Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q2Panel.add(next2Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton5.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText(" D. Juan de Salcedo");
        q2Panel.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton6.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton6.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText(" C. Andrés de Urdaneta");
        q2Panel.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton7.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton7.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setText(" B. Miguel López de Legazpi");
        q2Panel.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton8.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setText(" A. Ferdinand Magellan");
        q2Panel.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("2. Who led the successful Spanish expedition that established the first permanent settlement in the Philippines in 1565?");
        q2Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q2", q2Panel);

        q3Panel.setBackground(new java.awt.Color(53, 48, 128));
        q3Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next3Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next3Btn.setForeground(new java.awt.Color(255, 255, 255));
        next3Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next3Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next3Btn.setText("NEXT");
        next3Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q3Panel.add(next3Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton9.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton9.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText(" D. Batangas");
        q3Panel.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton10.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton10.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton10.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton10.setText(" C. Cavite");
        q3Panel.add(jRadioButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton11.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton11.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton11.setText(" B. Cebu");
        q3Panel.add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton12.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton12.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton12.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton12.setText(" A. Manila");
        q3Panel.add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("3. What was the name of the first permanent Spanish settlement in the Philippines?");
        q3Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q3", q3Panel);

        q4Panel.setBackground(new java.awt.Color(53, 48, 128));
        q4Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next4Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next4Btn.setForeground(new java.awt.Color(255, 255, 255));
        next4Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next4Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next4Btn.setText("NEXT");
        next4Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q4Panel.add(next4Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton13.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton13.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton13.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton13.setText(" D. Rajah Matanda");
        q4Panel.add(jRadioButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton14.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton14.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton14.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton14.setText(" C. Lapu-Lapu");
        q4Panel.add(jRadioButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton15.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton15.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton15.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton15.setText(" B. Rajah Sulayman");
        q4Panel.add(jRadioButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton16.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton16.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton16.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton16.setText(" A. Rajah Humabon");
        q4Panel.add(jRadioButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("4. Which native chieftain refused to accept Spanish authority and killed Ferdinand Magellan in the Battle of Mactan in 1521?");
        q4Panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q4", q4Panel);

        q5Panel.setBackground(new java.awt.Color(53, 48, 128));
        q5Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next5Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next5Btn.setForeground(new java.awt.Color(255, 255, 255));
        next5Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next5Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next5Btn.setText("NEXT");
        next5Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q5Panel.add(next5Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton17.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton17.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton17.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton17.setText(" D. Political asylum");
        q5Panel.add(jRadioButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton18.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton18.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton18.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton18.setText(" C. Scientific exploration");
        q5Panel.add(jRadioButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton19.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton19.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton19.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton19.setText(" B. God, Gold, and Glory (Christianity, wealth, and power)");
        q5Panel.add(jRadioButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton20.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton20.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton20.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton20.setText(" A.  Gold and spices");
        q5Panel.add(jRadioButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("5. What was the primary reason for Spanish colonization of the Philippines?");
        q5Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q5", q5Panel);

        q6Panel.setBackground(new java.awt.Color(53, 48, 128));
        q6Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next6Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next6Btn.setForeground(new java.awt.Color(255, 255, 255));
        next6Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next6Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next6Btn.setText("NEXT");
        next6Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q6Panel.add(next6Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton21.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton21.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton21.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton21.setText(" D. Tribute");
        q6Panel.add(jRadioButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton22.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton22.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton22.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton22.setText(" C. Hacienda");
        q6Panel.add(jRadioButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton23.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton23.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton23.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton23.setText(" B. Polo y Servicio");
        q6Panel.add(jRadioButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton24.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton24.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton24.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton24.setText(" A.  Encomienda");
        q6Panel.add(jRadioButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("6. What system did the Spanish implement where Filipino natives were required to work for the government without pay?");
        q6Panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q6", q6Panel);

        q7Panel.setBackground(new java.awt.Color(53, 48, 128));
        q7Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next7Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next7Btn.setForeground(new java.awt.Color(255, 255, 255));
        next7Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next7Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next7Btn.setText("NEXT");
        next7Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q7Panel.add(next7Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton25.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton25.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton25.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton25.setText(" D. Mestizos");
        q7Panel.add(jRadioButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton26.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton26.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton26.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton26.setText(" C.  Gobernadorcillos");
        q7Panel.add(jRadioButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton27.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton27.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton27.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton27.setText(" B. Encomenderos");
        q7Panel.add(jRadioButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton28.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton28.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton28.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton28.setText(" A. Friars");
        q7Panel.add(jRadioButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("7. Under the encomienda system, who were granted the right to collect tribute from Filipino natives in exchange for protection and religious instruction?");
        q7Panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q7", q7Panel);

        q8Panel.setBackground(new java.awt.Color(53, 48, 128));
        q8Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next8Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next8Btn.setForeground(new java.awt.Color(255, 255, 255));
        next8Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next8Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next8Btn.setText("NEXT");
        next8Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q8Panel.add(next8Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton29.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton29.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton29.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton29.setText(" D. All of the above");
        q8Panel.add(jRadioButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton30.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton30.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton30.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton30.setText(" C. Augustinians");
        q8Panel.add(jRadioButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton31.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton31.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton31.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton31.setText(" B. Franciscans");
        q8Panel.add(jRadioButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton32.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton32.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton32.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton32.setText(" A.  Dominicans");
        q8Panel.add(jRadioButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("8. Which religious order played the most significant role in spreading Christianity and education in the Spanish Philippines?");
        q8Panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q8", q8Panel);

        q9Panel.setBackground(new java.awt.Color(53, 48, 128));
        q9Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next9Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next9Btn.setForeground(new java.awt.Color(255, 255, 255));
        next9Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next9Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next9Btn.setText("NEXT");
        next9Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q9Panel.add(next9Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton33.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton33.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton33.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton33.setText(" D. Spanish Colonial Trade");
        q9Panel.add(jRadioButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton34.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton34.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton34.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton34.setText(" C. Asian-American Exchange");
        q9Panel.add(jRadioButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton35.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton35.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton35.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton35.setText(" B. Pacific Trade Route");
        q9Panel.add(jRadioButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton36.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton36.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton36.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton36.setText(" A. Manila-Acapulco Galleon Trade");
        q9Panel.add(jRadioButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("9. What was the Galleon Trade between the Philippines and Mexico called?");
        q9Panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q9", q9Panel);

        q10Panel.setBackground(new java.awt.Color(53, 48, 128));
        q10Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next10Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next10Btn.setForeground(new java.awt.Color(255, 255, 255));
        next10Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next10Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next10Btn.setText("NEXT");
        next10Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q10Panel.add(next10Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton37.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton37.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton37.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton37.setText(" D. 400 years");
        q10Panel.add(jRadioButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton38.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton38.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton38.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton38.setText(" C. 333 years");
        q10Panel.add(jRadioButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton39.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton39.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton39.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton39.setText(" B. 300 years");
        q10Panel.add(jRadioButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton40.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton40.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton40.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton40.setText(" A. 250 years");
        q10Panel.add(jRadioButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("10. How many years did Spanish colonial rule last in the Philippines?");
        q10Panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q10", q10Panel);

        q11Panel.setBackground(new java.awt.Color(53, 48, 128));
        q11Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next11Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next11Btn.setForeground(new java.awt.Color(255, 255, 255));
        next11Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next11Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next11Btn.setText("NEXT");
        next11Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q11Panel.add(next11Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton41.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton41.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton41.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton41.setText(" D.  Apolinario Mabini");
        q11Panel.add(jRadioButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton42.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton42.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton42.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton42.setText(" C.  Emilio Aguinaldo");
        q11Panel.add(jRadioButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton43.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton43.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton43.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton43.setText(" B.  Andrés Bonifacio");
        q11Panel.add(jRadioButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton44.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton44.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton44.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton44.setText(" A.  José Rizal");
        q11Panel.add(jRadioButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("11. Who is considered the \"Father of the Katipunan\" and a key leader in the Philippine Revolution against Spain?");
        q11Panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q11", q11Panel);

        q12Panel.setBackground(new java.awt.Color(53, 48, 128));
        q12Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next12Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next12Btn.setForeground(new java.awt.Color(255, 255, 255));
        next12Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next12Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next12Btn.setText("NEXT");
        next12Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q12Panel.add(next12Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton45.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton45.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton45.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton45.setText(" D. Sobre la Indolencia de los Filipinos");
        q12Panel.add(jRadioButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton46.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton46.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton46.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton46.setText(" C. Mi Último Adiós");
        q12Panel.add(jRadioButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton47.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton47.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton47.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton47.setText(" B.  Noli Me Tangere");
        q12Panel.add(jRadioButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton48.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton48.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton48.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton48.setText(" A. El Filibusterismo");
        q12Panel.add(jRadioButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("12. What was the name of José Rizal's novel that exposed the abuses of Spanish friars and colonial government?");
        q12Panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q12", q12Panel);

        q13Panel.setBackground(new java.awt.Color(53, 48, 128));
        q13Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next13Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next13Btn.setForeground(new java.awt.Color(255, 255, 255));
        next13Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next13Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next13Btn.setText("NEXT");
        next13Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q13Panel.add(next13Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton49.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton49.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton49.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton49.setText(" D. 1898");
        q13Panel.add(jRadioButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton50.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton50.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton50.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton50.setText(" C. 1565");
        q13Panel.add(jRadioButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton51.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton51.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton51.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton51.setText(" B. 1896");
        q13Panel.add(jRadioButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton52.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton52.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton52.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton52.setText(" A. 1892");
        q13Panel.add(jRadioButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("13. In what year was José Rizal executed by the Spanish colonial government?");
        q13Panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q13", q13Panel);

        q14Panel.setBackground(new java.awt.Color(53, 48, 128));
        q14Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next14Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next14Btn.setForeground(new java.awt.Color(255, 255, 255));
        next14Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next14Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next14Btn.setText("NEXT");
        next14Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q14Panel.add(next14Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton53.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton53.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton53.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton53.setText(" D. Pact of Biak-na-Bato");
        q14Panel.add(jRadioButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton54.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton54.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton54.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton54.setText(" C. Battle of Manila Bay");
        q14Panel.add(jRadioButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton55.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton55.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton55.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton55.setText(" B. Cavite Mutiny");
        q14Panel.add(jRadioButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton56.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton56.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton56.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton56.setText(" A.  Cry of Pugad Lawin");
        q14Panel.add(jRadioButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("14. What event in 1872 involved the execution of three Filipino priests (Gomburza) and fueled nationalist sentiment?");
        q14Panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q14", q14Panel);

        q15Panel.setBackground(new java.awt.Color(53, 48, 128));
        q15Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next15Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next15Btn.setForeground(new java.awt.Color(255, 255, 255));
        next15Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next15Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next15Btn.setText("NEXT");
        next15Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q15Panel.add(next15Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton57.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton57.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton57.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton57.setText(" D. Treaty of Versailles");
        q15Panel.add(jRadioButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton58.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton58.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton58.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton58.setText(" C.  Pact of Biak-na-Bato");
        q15Panel.add(jRadioButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton59.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton59.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton59.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton59.setText(" B. Treaty of Tordesillas");
        q15Panel.add(jRadioButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton60.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton60.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton60.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton60.setText(" A. Treaty of Paris (1898)");
        q15Panel.add(jRadioButton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("15. Which treaty ended Spanish colonial rule in the Philippines and ceded the islands to the United States?");
        q15Panel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q15", q15Panel);

        q16Panel.setBackground(new java.awt.Color(53, 48, 128));
        q16Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next16Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next16Btn.setForeground(new java.awt.Color(255, 255, 255));
        next16Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next16Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next16Btn.setText("NEXT");
        next16Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q16Panel.add(next16Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton61.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton61.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton61.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton61.setText(" D. Ilustrados");
        q16Panel.add(jRadioButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton62.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton62.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton62.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton62.setText(" C. Katipunan (KKK)");
        q16Panel.add(jRadioButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton63.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton63.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton63.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton63.setText(" B. Propaganda Movement");
        q16Panel.add(jRadioButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton64.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton64.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton64.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton64.setText(" A. La Liga Filipina");
        q16Panel.add(jRadioButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("16. What was the name of the secret revolutionary society founded by Andrés Bonifacio in 1892?");
        q16Panel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q16", q16Panel);

        q17Panel.setBackground(new java.awt.Color(53, 48, 128));
        q17Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        next17Btn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        next17Btn.setForeground(new java.awt.Color(255, 255, 255));
        next17Btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next17Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/next-button.png"))); // NOI18N
        next17Btn.setText("NEXT");
        next17Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q17Panel.add(next17Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 740, -1, -1));

        jRadioButton65.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton65.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton65.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton65.setText(" D. Calamba, Laguna");
        q17Panel.add(jRadioButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 70));

        jRadioButton66.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton66.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton66.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton66.setText(" C. Kawit, Cavite");
        q17Panel.add(jRadioButton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jRadioButton67.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton67.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton67.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton67.setText(" B. Malolos, Bulacan");
        q17Panel.add(jRadioButton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 70));

        jRadioButton68.setBackground(new java.awt.Color(53, 48, 128));
        jRadioButton68.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jRadioButton68.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton68.setText(" A. Manila");
        q17Panel.add(jRadioButton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 70));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("17. Where did Emilio Aguinaldo declare Philippine independence from Spain on June 12, 1898?");
        q17Panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        contentsTabbedPane.addTab("Q17", q17Panel);

        resultPanel.setBackground(new java.awt.Color(53, 48, 128));
        resultPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retakeQuizBtn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        retakeQuizBtn.setForeground(new java.awt.Color(255, 255, 255));
        retakeQuizBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        retakeQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/result-button.png"))); // NOI18N
        retakeQuizBtn.setText("GO TO DASHBOARD");
        retakeQuizBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resultPanel.add(retakeQuizBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 750, -1, -1));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("RESULT");
        resultPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, -1, -1));

        retakeQuizBtn2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        retakeQuizBtn2.setForeground(new java.awt.Color(255, 255, 255));
        retakeQuizBtn2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        retakeQuizBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/result-button.png"))); // NOI18N
        retakeQuizBtn2.setText("RETAKE QUIZ");
        retakeQuizBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resultPanel.add(retakeQuizBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 750, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Score:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        scoreLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        scoreLbl.setForeground(new java.awt.Color(255, 255, 255));
        scoreLbl.setText("score here");
        jPanel1.add(scoreLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Percentage:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        percentageLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        percentageLbl.setForeground(new java.awt.Color(255, 255, 255));
        percentageLbl.setText("percentage here");
        jPanel1.add(percentageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Remark:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        remarkLbl1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        remarkLbl1.setForeground(new java.awt.Color(255, 255, 255));
        remarkLbl1.setText("remark here");
        jPanel1.add(remarkLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Recommendation:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        remarkLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        remarkLbl.setForeground(new java.awt.Color(255, 255, 255));
        remarkLbl.setText("placeholder");
        remarkLbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        remarkLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(remarkLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 340, 360));

        resultPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 360, 560));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q17AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q17AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q17AnsLbl.setText("q17 ans");
        jPanel3.add(q17AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, -1, -1));

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Question 2: ");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Question 3: ");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Question 4: ");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Question 5: ");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Question 6: ");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Question 7: ");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Question 8: ");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Question 9: ");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Question 10: ");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Question 11: ");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Question 12: ");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        jLabel38.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Question 13: ");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Question 14: ");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        jLabel40.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Question 15: ");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, -1));

        jLabel41.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Question 16: ");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, -1, -1));

        jLabel42.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Question 17: ");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, -1, -1));

        q17EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q17EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q17EvalLbl.setText("???");
        jPanel3.add(q17EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, -1, -1));

        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Question 1: ");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        q1AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q1AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q1AnsLbl.setText("q1 ans");
        jPanel3.add(q1AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        q2AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q2AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q2AnsLbl.setText("q2 ans");
        jPanel3.add(q2AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        q3AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q3AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q3AnsLbl.setText("q3 ans");
        jPanel3.add(q3AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        q4AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q4AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q4AnsLbl.setText("q4 ans");
        jPanel3.add(q4AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        q5AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q5AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q5AnsLbl.setText("q5 ans");
        jPanel3.add(q5AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        q6AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q6AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q6AnsLbl.setText("q6 ans");
        jPanel3.add(q6AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        q7AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q7AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q7AnsLbl.setText("q7 ans");
        jPanel3.add(q7AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        q8AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q8AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q8AnsLbl.setText("q8 ans");
        jPanel3.add(q8AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        q9AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q9AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q9AnsLbl.setText("q9 ans");
        jPanel3.add(q9AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        q10AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q10AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q10AnsLbl.setText("q10 ans");
        jPanel3.add(q10AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        q11AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q11AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q11AnsLbl.setText("q11 ans");
        jPanel3.add(q11AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        q12AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q12AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q12AnsLbl.setText("q12 ans");
        jPanel3.add(q12AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        q13AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q13AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q13AnsLbl.setText("q13 ans");
        jPanel3.add(q13AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        q14AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q14AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q14AnsLbl.setText("q14 ans");
        jPanel3.add(q14AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, -1));

        q15AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q15AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q15AnsLbl.setText("q15 ans");
        jPanel3.add(q15AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, -1, -1));

        q16AnsLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q16AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q16AnsLbl.setText("q16 ans");
        jPanel3.add(q16AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, -1, -1));

        q1EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q1EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q1EvalLbl.setText("???");
        jPanel3.add(q1EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        q2EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q2EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q2EvalLbl.setText("???");
        jPanel3.add(q2EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        scoreLbl1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        scoreLbl1.setForeground(new java.awt.Color(255, 255, 255));
        scoreLbl1.setText("SUMMARY");
        jPanel3.add(scoreLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        q3EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q3EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q3EvalLbl.setText("???");
        jPanel3.add(q3EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        q4EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q4EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q4EvalLbl.setText("???");
        jPanel3.add(q4EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        q5EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q5EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q5EvalLbl.setText("???");
        jPanel3.add(q5EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        q6EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q6EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q6EvalLbl.setText("???");
        jPanel3.add(q6EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        q7EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q7EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q7EvalLbl.setText("???");
        jPanel3.add(q7EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        q8EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q8EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q8EvalLbl.setText("???");
        jPanel3.add(q8EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        q9EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q9EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q9EvalLbl.setText("???");
        jPanel3.add(q9EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        q10EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q10EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q10EvalLbl.setText("???");
        jPanel3.add(q10EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        q11EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q11EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q11EvalLbl.setText("???");
        jPanel3.add(q11EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));

        q12EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q12EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q12EvalLbl.setText("???");
        jPanel3.add(q12EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));

        q13EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q13EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q13EvalLbl.setText("???");
        jPanel3.add(q13EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        q14EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q14EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q14EvalLbl.setText("???");
        jPanel3.add(q14EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, -1));

        q15EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q15EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q15EvalLbl.setText("???");
        jPanel3.add(q15EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        q16EvalLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        q16EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q16EvalLbl.setText("???");
        jPanel3.add(q16EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, -1, -1));

        resultPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 630, 560));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        resultPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 140, 480, 560));

        contentsTabbedPane.addTab("Result", resultPanel);

        mainPanel.add(contentsTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 160, 1886, 900));

        titleLbl.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(230, 238, 248));
        titleLbl.setText("Placeholder");
        mainPanel.add(titleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 95, -1, -1));

        timer.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        timer.setForeground(new java.awt.Color(255, 255, 255));
        timer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/timer-button.png"))); // NOI18N
        timer.setText("00:00");
        timer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        timer.setIconTextGap(0);
        mainPanel.add(timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1786, 110, -1, -1));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        java.awt.EventQueue.invokeLater(() -> new QuizUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtn1;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JTabbedPane contentsTabbedPane;
    private javax.swing.JLabel instructionsLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton41;
    private javax.swing.JRadioButton jRadioButton42;
    private javax.swing.JRadioButton jRadioButton43;
    private javax.swing.JRadioButton jRadioButton44;
    private javax.swing.JRadioButton jRadioButton45;
    private javax.swing.JRadioButton jRadioButton46;
    private javax.swing.JRadioButton jRadioButton47;
    private javax.swing.JRadioButton jRadioButton48;
    private javax.swing.JRadioButton jRadioButton49;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton50;
    private javax.swing.JRadioButton jRadioButton51;
    private javax.swing.JRadioButton jRadioButton52;
    private javax.swing.JRadioButton jRadioButton53;
    private javax.swing.JRadioButton jRadioButton54;
    private javax.swing.JRadioButton jRadioButton55;
    private javax.swing.JRadioButton jRadioButton56;
    private javax.swing.JRadioButton jRadioButton57;
    private javax.swing.JRadioButton jRadioButton58;
    private javax.swing.JRadioButton jRadioButton59;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton60;
    private javax.swing.JRadioButton jRadioButton61;
    private javax.swing.JRadioButton jRadioButton62;
    private javax.swing.JRadioButton jRadioButton63;
    private javax.swing.JRadioButton jRadioButton64;
    private javax.swing.JRadioButton jRadioButton65;
    private javax.swing.JRadioButton jRadioButton66;
    private javax.swing.JRadioButton jRadioButton67;
    private javax.swing.JRadioButton jRadioButton68;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel minimizeBtn;
    private javax.swing.JLabel next10Btn;
    private javax.swing.JLabel next11Btn;
    private javax.swing.JLabel next12Btn;
    private javax.swing.JLabel next13Btn;
    private javax.swing.JLabel next14Btn;
    private javax.swing.JLabel next15Btn;
    private javax.swing.JLabel next16Btn;
    private javax.swing.JLabel next17Btn;
    private javax.swing.JLabel next1Btn;
    private javax.swing.JLabel next2Btn;
    private javax.swing.JLabel next3Btn;
    private javax.swing.JLabel next4Btn;
    private javax.swing.JLabel next5Btn;
    private javax.swing.JLabel next6Btn;
    private javax.swing.JLabel next7Btn;
    private javax.swing.JLabel next8Btn;
    private javax.swing.JLabel next9Btn;
    private javax.swing.JLabel percentageLbl;
    private javax.swing.JLabel q10AnsLbl;
    private javax.swing.JLabel q10EvalLbl;
    private javax.swing.JPanel q10Panel;
    private javax.swing.JLabel q11AnsLbl;
    private javax.swing.JLabel q11EvalLbl;
    private javax.swing.JPanel q11Panel;
    private javax.swing.JLabel q12AnsLbl;
    private javax.swing.JLabel q12EvalLbl;
    private javax.swing.JPanel q12Panel;
    private javax.swing.JLabel q13AnsLbl;
    private javax.swing.JLabel q13EvalLbl;
    private javax.swing.JPanel q13Panel;
    private javax.swing.JLabel q14AnsLbl;
    private javax.swing.JLabel q14EvalLbl;
    private javax.swing.JPanel q14Panel;
    private javax.swing.JLabel q15AnsLbl;
    private javax.swing.JLabel q15EvalLbl;
    private javax.swing.JPanel q15Panel;
    private javax.swing.JLabel q16AnsLbl;
    private javax.swing.JLabel q16EvalLbl;
    private javax.swing.JPanel q16Panel;
    private javax.swing.JLabel q17AnsLbl;
    private javax.swing.JLabel q17EvalLbl;
    private javax.swing.JPanel q17Panel;
    private javax.swing.JLabel q1AnsLbl;
    private javax.swing.JLabel q1EvalLbl;
    private javax.swing.JPanel q1Panel;
    private javax.swing.JLabel q2AnsLbl;
    private javax.swing.JLabel q2EvalLbl;
    private javax.swing.JPanel q2Panel;
    private javax.swing.JLabel q3AnsLbl;
    private javax.swing.JLabel q3EvalLbl;
    private javax.swing.JPanel q3Panel;
    private javax.swing.JLabel q4AnsLbl;
    private javax.swing.JLabel q4EvalLbl;
    private javax.swing.JPanel q4Panel;
    private javax.swing.JLabel q5AnsLbl;
    private javax.swing.JLabel q5EvalLbl;
    private javax.swing.JPanel q5Panel;
    private javax.swing.JLabel q6AnsLbl;
    private javax.swing.JLabel q6EvalLbl;
    private javax.swing.JPanel q6Panel;
    private javax.swing.JLabel q7AnsLbl;
    private javax.swing.JLabel q7EvalLbl;
    private javax.swing.JPanel q7Panel;
    private javax.swing.JLabel q8AnsLbl;
    private javax.swing.JLabel q8EvalLbl;
    private javax.swing.JPanel q8Panel;
    private javax.swing.JLabel q9AnsLbl;
    private javax.swing.JLabel q9EvalLbl;
    private javax.swing.JPanel q9Panel;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JLabel remarkLbl1;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JLabel retakeQuizBtn;
    private javax.swing.JLabel retakeQuizBtn2;
    private javax.swing.JLabel scoreLbl;
    private javax.swing.JLabel scoreLbl1;
    private javax.swing.JLabel startQuizBtn;
    private javax.swing.JPanel startquizPanel;
    private javax.swing.JLabel timer;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
