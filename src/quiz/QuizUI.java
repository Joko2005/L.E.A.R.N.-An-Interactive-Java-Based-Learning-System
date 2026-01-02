package quiz;

import commons.NavigationUtil;
import commons.UIUtils;
import dashboard.UI.DashboardUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class QuizUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(QuizUI.class.getName());
    private JFrame parent;
    
    public QuizUI(JFrame parent) {
        setUndecorated(true);  
        this.parent = parent;
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
        QuizInstructions();
        ResetSummary();
    }
    
    private void FullScreen(){
        this.setExtendedState(JFrame. MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    // ============================================================================================================================
    
    private void QuizInstructions(){
        instructionsLbl.setText("<html>" +
            "<div style='width: 700px; font-size: 14px; color: #C3C9D9; line-height: 1.6;'>" +
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
        IntializeQuestions();
        currentlyTakingQuiz = true;
        startTimer();
    }
    
    private void TextPlaceholder(int num){
        int current = num;
        int maximum = 17;
        String text = String.format("<html>Question <b>%d</b> of <b>%d</b></html>", current, maximum);
        titleLbl.setText(text);
    }
    
    private boolean Evaluate(JRadioButton answer, JPanel addThis){
        boolean isCorrect = CheckIfAnswerIsCorrect(answer);
        AddScore(isCorrect);
        MessaageBox(isCorrect);
        Tabs(addThis);
        return isCorrect;
    }
    
    private void Result(){
        int score = Score;
        double percentage = (score * 100.0) / 17;
        String remark = Remark(percentage);
        String recommendation = Recommendation(percentage);
        
        scoreLbl.setText(score + "/17");
        percentageLbl.setText(String.format("%.2f%%", percentage));
        remarkLbl.setText(remark);
        recommendationLbl.setText(recommendation);
    }
    
    private String Remark(double percent) {
        String remark;

        if (percent >= 88.24) { // 15-17 correct = 88.24%-100%
            remark = "Excellent";
        }
        else if (percent >= 70.59) { // 12-14 correct = 70.59%-82.35%
            remark = "Very Good";
        }
        else if (percent >= 52.94) { // 9-11 correct = 52.94%-64.71%
            remark = "Fair";
        }
        else { // 0-8 correct = 0%-47.06%
            remark = "Failed";
        }

        return remark; 
    }
    
    private void DisplaySummary(boolean isCorrect, ButtonGroup bg, JLabel answer, JLabel evaluation){
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                String buttonText = button.getText();
                answer.setText(buttonText.substring(0, 2));
                break;
            }
        }
        
        if(isCorrect){
            evaluation.setText("Correct");
        }
    }
    
    private void ResetSummary(){
        JLabel[] ans = {
            q1AnsLbl,
            q2AnsLbl,
            q3AnsLbl,
            q4AnsLbl,
            q5AnsLbl,
            q6AnsLbl,
            q7AnsLbl,
            q8AnsLbl,
            q9AnsLbl,
            q10AnsLbl,
            q11AnsLbl,
            q12AnsLbl,
            q13AnsLbl,
            q14AnsLbl,
            q15AnsLbl,
            q16AnsLbl,
            q17AnsLbl,
        };
        
        
        JLabel[] eval = {
            q1EvalLbl,
            q2EvalLbl,
            q3EvalLbl,
            q4EvalLbl,
            q5EvalLbl,
            q6EvalLbl,
            q7EvalLbl,
            q8EvalLbl,
            q9EvalLbl,
            q10EvalLbl,
            q11EvalLbl,
            q12EvalLbl,
            q13EvalLbl,
            q14EvalLbl,
            q15EvalLbl,
            q16EvalLbl,
            q17EvalLbl
        };
        
        for(JLabel x : ans){
            x.setText("None");
        }
        
        for(JLabel x :  eval){
            x.setText("Incorrect");
        }
    }
    
    private String Recommendation(double percent) {
        String text;

        if (percent >= 88.24) {
            text = "Outstanding performance! You have demonstrated exceptional understanding of the material. " +
                   "Consider exploring advanced topics or mentoring others to reinforce your knowledge.";
        } 
        else if (percent >= 70.59) {
            text = "Great job! You have a solid grasp of the concepts. " +
                   "Review the questions you missed to strengthen your understanding further.";
        } 
        else if (percent >= 52.94) {
            text = "You passed, but there's room for improvement. " +
                   "Focus on reviewing the topics where you struggled and consider retaking the quiz after additional study.";
        } 
        else {
            text = "You did not pass this time.  Don't be discouraged! " +
                   "Review all the material thoroughly, especially the questions you got wrong.  " +
                   "Take your time to understand each concept before retaking the quiz.";
        }
    
    // Wrap in HTML with styling
    return String.format("<html><body style='width: 100%%; line-height: 1.6;'>%s</body></html>", text);
}
    
    // ============================================================================================================================
    
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
    
    /* FOR RADIO BUTTONS */
    
    ButtonGroup q1 = new ButtonGroup();
    ButtonGroup q2 = new ButtonGroup();
    ButtonGroup q3 = new ButtonGroup();
    ButtonGroup q4 = new ButtonGroup();
    ButtonGroup q5 = new ButtonGroup();
    ButtonGroup q6 = new ButtonGroup();
    ButtonGroup q7 = new ButtonGroup();
    ButtonGroup q8 = new ButtonGroup();
    ButtonGroup q9 = new ButtonGroup();
    ButtonGroup q10 = new ButtonGroup();
    ButtonGroup q11 = new ButtonGroup();
    ButtonGroup q12 = new ButtonGroup();
    ButtonGroup q13 = new ButtonGroup();
    ButtonGroup q14 = new ButtonGroup();
    ButtonGroup q15 = new ButtonGroup();
    ButtonGroup q16 = new ButtonGroup();
    ButtonGroup q17 = new ButtonGroup();
    private void Question1(){
        q1.add(Aq1RadioBtn);
        q1.add(Bq1RadioBtn);
        q1.add(Cq1RadioBtn);
        q1.add(Dq1RadioBtn);
    }
    private void Question2(){
        q2.add(Aq2RadioBtn);
        q2.add(Bq2RadioBtn);
        q2.add(Cq2RadioBtn);
        q2.add(Dq2RadioBtn);
    }
    private void Question3(){
        q3.add(Aq3RadioBtn);
        q3.add(Bq3RadioBtn);
        q3.add(Cq3RadioBtn);
        q3.add(Dq3RadioBtn);
    }
    private void Question4(){
        q4.add(Aq4RadioBtn);
        q4.add(Bq4RadioBtn);
        q4.add(Cq4RadioBtn);
        q4.add(Dq4RadioBtn);
    }
    private void Question5(){
        q5.add(Aq5RadioBtn);
        q5.add(Bq5RadioBtn);
        q5.add(Cq5RadioBtn);
        q5.add(Dq5RadioBtn);
    }
    private void Question6(){
        q6.add(Aq6RadioBtn);
        q6.add(Bq6RadioBtn);
        q6.add(Cq6RadioBtn);
        q6.add(Dq6RadioBtn);
    }
    private void Question7(){
        q7.add(Aq7RadioBtn);
        q7.add(Bq7RadioBtn);
        q7.add(Cq7RadioBtn);
        q7.add(Dq7RadioBtn);
    }
    private void Question8(){
        q8.add(Aq8RadioBtn);
        q8.add(Bq8RadioBtn);
        q8.add(Cq8RadioBtn);
        q8.add(Dq8RadioBtn);
    }
    private void Question9(){
        q9.add(Aq9RadioBtn);
        q9.add(Bq9RadioBtn);
        q9.add(Cq9RadioBtn);
        q9.add(Dq9RadioBtn);
    }
    private void Question10(){
        q10.add(Aq10RadioBtn);
        q10.add(Bq10RadioBtn);
        q10.add(Cq10RadioBtn);
        q10.add(Dq10RadioBtn);
    }
    private void Question11(){
        q11.add(Aq11RadioBtn);
        q11.add(Bq11RadioBtn);
        q11.add(Cq11RadioBtn);
        q11.add(Dq11RadioBtn);
    }
    private void Question12(){
        q12.add(Aq12RadioBtn);
        q12.add(Bq12RadioBtn);
        q12.add(Cq12RadioBtn);
        q12.add(Dq12RadioBtn);
    }
    private void Question13(){
        q13.add(Aq13RadioBtn);
        q13.add(Bq13RadioBtn);
        q13.add(Cq13RadioBtn);
        q13.add(Dq13RadioBtn);
    }
    private void Question14(){
        q14.add(Aq14RadioBtn);
        q14.add(Bq14RadioBtn);
        q14.add(Cq14RadioBtn);
        q14.add(Dq14RadioBtn);
    }
    private void Question15(){
        q15.add(Aq15RadioBtn);
        q15.add(Bq15RadioBtn);
        q15.add(Cq15RadioBtn);
        q15.add(Dq15RadioBtn);
    }
    private void Question16(){
        q16.add(Aq16RadioBtn);
        q16.add(Bq16RadioBtn);
        q16.add(Cq16RadioBtn);
        q16.add(Dq16RadioBtn);
    }
    private void Question17(){
        q17.add(Aq17RadioBtn);
        q17.add(Bq17RadioBtn);
        q17.add(Cq17RadioBtn);
        q17.add(Dq17RadioBtn);
    }
    private void IntializeQuestions(){
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
        Question7();
        Question8();
        Question9();
        Question10();
        Question11();
        Question12();
        Question13();
        Question14();
        Question15();
        Question16();
        Question17();
    }
    private void DeselectAll(){
        q1.clearSelection();
        q2.clearSelection();
        q3.clearSelection();
        q4.clearSelection();
        q5.clearSelection();
        q6.clearSelection();
        q7.clearSelection();
        q8.clearSelection();
        q9.clearSelection();
        q10.clearSelection();
        q11.clearSelection();
        q12.clearSelection();
        q13.clearSelection();
        q14.clearSelection();
        q15.clearSelection();
        q16.clearSelection();
        q17.clearSelection();
    }
    
    // ============================================================================================================================
    
    /* FOR EVALUATION OF ANSWERS */
    
    private boolean CheckIfAnswerIsCorrect(JRadioButton answer){
        boolean isCorrect = false;
        if(answer.isSelected()){
            isCorrect = true;
        }
        return isCorrect;
    }
    
    private int Score = 0;
    private void AddScore(boolean isCorrect){
        if(isCorrect){
            Score++;
        }
    }
    
    private void ResetScore(){
        Score = 0;
    }
    
    private void MessaageBox(boolean isCorrect){
        if(isCorrect){
            JOptionPane.showMessageDialog(null, "Correct", "Evaluation", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Incorrect", "Evaluation", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ============================================================================================================================
    
    /* FOR TIMER */
    
    private javax.swing.Timer quizTimer;
    private int remainingSeconds = 600;

    // Start the timer
    private void startTimer() {
        remainingSeconds = 600;

        quizTimer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingSeconds--;
                updateTimerDisplay();
                
                if (remainingSeconds <= 0) {
                    quizTimer.stop();
                    onTimeUp();
                }
            }
        });

        quizTimer.start();
        updateTimerDisplay(); 
    }

    private void updateTimerDisplay() {
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        String timeString = String.format("%02d:%02d", minutes, seconds);
        timerLbl.setText(timeString);

        if (remainingSeconds <= 60) {
            timerLbl.setForeground(new Color(248, 113, 113)); // Red
        } else if (remainingSeconds <= 180) { 
            timerLbl.setForeground(new Color(251, 191, 36)); // Yellow
        } else {
            timerLbl.setForeground(new Color(255,255,255)); // Normal color
        }
    }

    private void onTimeUp() {
        JOptionPane.showMessageDialog(this, 
            "Time's up!  The quiz will be submitted automatically.", 
            "Time Expired", 
            JOptionPane. WARNING_MESSAGE);
        
        currentlyTakingQuiz = false;
        Result();
        Tabs(resultPanel);
//        ResetSummary();
    }

    private void stopTimer() {
        if (quizTimer != null && quizTimer.isRunning()) {
            quizTimer.stop();
        }
    }
    
    boolean currentlyTakingQuiz = false; // this will be used for the close button whenver the user is currently taking quiz
    
    // ============================================================================================================================
    
    private void ResetAll(){
        ResetSummary();
        ResetScore();
        DeselectAll();
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
        jLabel4 = new javax.swing.JLabel();
        backBtn = new commons.RoundButton();
        minimizeBtn = new commons.RoundButton();
        closeBtn = new commons.RoundButton();
        contentsTabbedPane = new javax.swing.JTabbedPane();
        startquizPanel = new javax.swing.JPanel();
        instructionsLbl = new javax.swing.JLabel();
        startQuizBtn = new commons.GradientButton();
        q1Panel = new javax.swing.JPanel();
        q1image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Dq1RadioBtn = new javax.swing.JRadioButton();
        Aq1RadioBtn = new javax.swing.JRadioButton();
        Bq1RadioBtn = new javax.swing.JRadioButton();
        Cq1RadioBtn = new javax.swing.JRadioButton();
        q1border2 = new javax.swing.JLabel();
        q1border4 = new javax.swing.JLabel();
        q1border1 = new javax.swing.JLabel();
        q1border3 = new javax.swing.JLabel();
        next1Btn = new commons.GradientButton();
        q2Panel = new javax.swing.JPanel();
        Dq2RadioBtn = new javax.swing.JRadioButton();
        Cq2RadioBtn = new javax.swing.JRadioButton();
        Bq2RadioBtn = new javax.swing.JRadioButton();
        Aq2RadioBtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        next1Btn6 = new javax.swing.JLabel();
        next1Btn7 = new javax.swing.JLabel();
        next1Btn8 = new javax.swing.JLabel();
        next1Btn9 = new javax.swing.JLabel();
        q2image = new javax.swing.JLabel();
        next2Btn = new commons.GradientButton();
        q3Panel = new javax.swing.JPanel();
        Dq3RadioBtn = new javax.swing.JRadioButton();
        Cq3RadioBtn = new javax.swing.JRadioButton();
        Bq3RadioBtn = new javax.swing.JRadioButton();
        Aq3RadioBtn = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        next1Btn10 = new javax.swing.JLabel();
        next1Btn11 = new javax.swing.JLabel();
        next1Btn12 = new javax.swing.JLabel();
        next1Btn13 = new javax.swing.JLabel();
        q3image = new javax.swing.JLabel();
        next3Btn = new commons.GradientButton();
        q4Panel = new javax.swing.JPanel();
        Dq4RadioBtn = new javax.swing.JRadioButton();
        Cq4RadioBtn = new javax.swing.JRadioButton();
        Bq4RadioBtn = new javax.swing.JRadioButton();
        Aq4RadioBtn = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        next1Btn14 = new javax.swing.JLabel();
        next1Btn15 = new javax.swing.JLabel();
        next1Btn16 = new javax.swing.JLabel();
        next1Btn17 = new javax.swing.JLabel();
        q4image = new javax.swing.JLabel();
        next4tn = new commons.GradientButton();
        q5Panel = new javax.swing.JPanel();
        Dq5RadioBtn = new javax.swing.JRadioButton();
        Cq5RadioBtn = new javax.swing.JRadioButton();
        Bq5RadioBtn = new javax.swing.JRadioButton();
        Aq5RadioBtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        next1Btn18 = new javax.swing.JLabel();
        next1Btn19 = new javax.swing.JLabel();
        next1Btn20 = new javax.swing.JLabel();
        next1Btn21 = new javax.swing.JLabel();
        q5image = new javax.swing.JLabel();
        next5Btn = new commons.GradientButton();
        q6Panel = new javax.swing.JPanel();
        Dq6RadioBtn = new javax.swing.JRadioButton();
        Cq6RadioBtn = new javax.swing.JRadioButton();
        Bq6RadioBtn = new javax.swing.JRadioButton();
        Aq6RadioBtn = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        next1Btn22 = new javax.swing.JLabel();
        next1Btn23 = new javax.swing.JLabel();
        next1Btn24 = new javax.swing.JLabel();
        next1Btn25 = new javax.swing.JLabel();
        next1Btn74 = new javax.swing.JLabel();
        next6Btn = new commons.GradientButton();
        q7Panel = new javax.swing.JPanel();
        Dq7RadioBtn = new javax.swing.JRadioButton();
        Cq7RadioBtn = new javax.swing.JRadioButton();
        Bq7RadioBtn = new javax.swing.JRadioButton();
        Aq7RadioBtn = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        next1Btn26 = new javax.swing.JLabel();
        next1Btn27 = new javax.swing.JLabel();
        next1Btn28 = new javax.swing.JLabel();
        next1Btn29 = new javax.swing.JLabel();
        next1Btn75 = new javax.swing.JLabel();
        next7Btn = new commons.GradientButton();
        q8Panel = new javax.swing.JPanel();
        Dq8RadioBtn = new javax.swing.JRadioButton();
        Cq8RadioBtn = new javax.swing.JRadioButton();
        Bq8RadioBtn = new javax.swing.JRadioButton();
        Aq8RadioBtn = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        next1Btn30 = new javax.swing.JLabel();
        next1Btn31 = new javax.swing.JLabel();
        next1Btn32 = new javax.swing.JLabel();
        next1Btn33 = new javax.swing.JLabel();
        next1Btn76 = new javax.swing.JLabel();
        next8Btn = new commons.GradientButton();
        q9Panel = new javax.swing.JPanel();
        Dq9RadioBtn = new javax.swing.JRadioButton();
        Cq9RadioBtn = new javax.swing.JRadioButton();
        Bq9RadioBtn = new javax.swing.JRadioButton();
        Aq9RadioBtn = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        next1Btn34 = new javax.swing.JLabel();
        next1Btn35 = new javax.swing.JLabel();
        next1Btn36 = new javax.swing.JLabel();
        next1Btn37 = new javax.swing.JLabel();
        next1Btn77 = new javax.swing.JLabel();
        next9Btn = new commons.GradientButton();
        q10Panel = new javax.swing.JPanel();
        Dq10RadioBtn = new javax.swing.JRadioButton();
        Cq10RadioBtn = new javax.swing.JRadioButton();
        Bq10RadioBtn = new javax.swing.JRadioButton();
        Aq10RadioBtn = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        next1Btn78 = new javax.swing.JLabel();
        next1Btn86 = new javax.swing.JLabel();
        next1Btn87 = new javax.swing.JLabel();
        next1Btn88 = new javax.swing.JLabel();
        next1Btn89 = new javax.swing.JLabel();
        next10Btn = new commons.GradientButton();
        q11Panel = new javax.swing.JPanel();
        Dq11RadioBtn = new javax.swing.JRadioButton();
        Cq11RadioBtn = new javax.swing.JRadioButton();
        Bq11RadioBtn = new javax.swing.JRadioButton();
        Aq11RadioBtn = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        next1Btn79 = new javax.swing.JLabel();
        next1Btn90 = new javax.swing.JLabel();
        next1Btn91 = new javax.swing.JLabel();
        next1Btn92 = new javax.swing.JLabel();
        next1Btn93 = new javax.swing.JLabel();
        next11Btn = new commons.GradientButton();
        q12Panel = new javax.swing.JPanel();
        Dq12RadioBtn = new javax.swing.JRadioButton();
        Cq12RadioBtn = new javax.swing.JRadioButton();
        Bq12RadioBtn = new javax.swing.JRadioButton();
        Aq12RadioBtn = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        next1Btn80 = new javax.swing.JLabel();
        next1Btn94 = new javax.swing.JLabel();
        next1Btn95 = new javax.swing.JLabel();
        next1Btn96 = new javax.swing.JLabel();
        next1Btn97 = new javax.swing.JLabel();
        next12Btn = new commons.GradientButton();
        q13Panel = new javax.swing.JPanel();
        Dq13RadioBtn = new javax.swing.JRadioButton();
        Cq13RadioBtn = new javax.swing.JRadioButton();
        Bq13RadioBtn = new javax.swing.JRadioButton();
        Aq13RadioBtn = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        next1Btn81 = new javax.swing.JLabel();
        next1Btn98 = new javax.swing.JLabel();
        next1Btn99 = new javax.swing.JLabel();
        next1Btn100 = new javax.swing.JLabel();
        next1Btn101 = new javax.swing.JLabel();
        next13Btn = new commons.GradientButton();
        q14Panel = new javax.swing.JPanel();
        Dq14RadioBtn = new javax.swing.JRadioButton();
        Cq14RadioBtn = new javax.swing.JRadioButton();
        Bq14RadioBtn = new javax.swing.JRadioButton();
        Aq14RadioBtn = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        next1Btn82 = new javax.swing.JLabel();
        next1Btn102 = new javax.swing.JLabel();
        next1Btn103 = new javax.swing.JLabel();
        next1Btn104 = new javax.swing.JLabel();
        next1Btn105 = new javax.swing.JLabel();
        next14Btn = new commons.GradientButton();
        q15Panel = new javax.swing.JPanel();
        Dq15RadioBtn = new javax.swing.JRadioButton();
        Cq15RadioBtn = new javax.swing.JRadioButton();
        Bq15RadioBtn = new javax.swing.JRadioButton();
        Aq15RadioBtn = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        next1Btn83 = new javax.swing.JLabel();
        next1Btn106 = new javax.swing.JLabel();
        next1Btn107 = new javax.swing.JLabel();
        next1Btn108 = new javax.swing.JLabel();
        next1Btn109 = new javax.swing.JLabel();
        next15Btn = new commons.GradientButton();
        q16Panel = new javax.swing.JPanel();
        Dq16RadioBtn = new javax.swing.JRadioButton();
        Cq16RadioBtn = new javax.swing.JRadioButton();
        Bq16RadioBtn = new javax.swing.JRadioButton();
        Aq16RadioBtn = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        next1Btn84 = new javax.swing.JLabel();
        next1Btn110 = new javax.swing.JLabel();
        next1Btn111 = new javax.swing.JLabel();
        next1Btn112 = new javax.swing.JLabel();
        next1Btn113 = new javax.swing.JLabel();
        next16Btn = new commons.GradientButton();
        q17Panel = new javax.swing.JPanel();
        Dq17RadioBtn = new javax.swing.JRadioButton();
        Cq17RadioBtn = new javax.swing.JRadioButton();
        Bq17RadioBtn = new javax.swing.JRadioButton();
        Aq17RadioBtn = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        next1Btn85 = new javax.swing.JLabel();
        next1Btn114 = new javax.swing.JLabel();
        next1Btn115 = new javax.swing.JLabel();
        next1Btn116 = new javax.swing.JLabel();
        next1Btn117 = new javax.swing.JLabel();
        next17Btn = new commons.GradientButton();
        resultPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        scoreLbl = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        percentageLbl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        recommendationLbl = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
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
        goToDashboardBtn = new commons.GradientButton();
        retakeQuizBtn = new commons.GradientButton();
        leftSideBorder = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        timerLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(14, 22, 48));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(14, 22, 48));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 45, 114));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 77));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 77));
        jPanel2.setPreferredSize(new java.awt.Dimension(1520, 77));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 176, 200));
        jLabel2.setText("History Quiz");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 238, 248));
        jLabel4.setText("TAKE QUIZ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        backBtn.setBorder(null);
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("BACK");
        backBtn.setBorderColor(new java.awt.Color(75, 74, 151));
        backBtn.setBorderEnabled(false);
        backBtn.setBorderPainted(false);
        backBtn.setColor(new java.awt.Color(75, 74, 151));
        backBtn.setColorClick(new java.awt.Color(48, 43, 116));
        backBtn.setColorOver(new java.awt.Color(48, 43, 116));
        backBtn.setFocusable(false);
        backBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        backBtn.setRadius(10);
        backBtn.addActionListener(this::backBtnActionPerformed);
        jPanel2.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 20, 136, 39));

        minimizeBtn.setBorder(null);
        minimizeBtn.setForeground(new java.awt.Color(255, 255, 255));
        minimizeBtn.setText("–");
        minimizeBtn.setBorderColor(new java.awt.Color(75, 74, 151));
        minimizeBtn.setBorderEnabled(false);
        minimizeBtn.setBorderPainted(false);
        minimizeBtn.setColor(new java.awt.Color(75, 74, 151));
        minimizeBtn.setColorClick(new java.awt.Color(48, 43, 116));
        minimizeBtn.setColorOver(new java.awt.Color(48, 43, 116));
        minimizeBtn.setFocusable(false);
        minimizeBtn.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        minimizeBtn.setRadius(10);
        minimizeBtn.addActionListener(this::minimizeBtnActionPerformed);
        jPanel2.add(minimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1800, 20, 40, 39));

        closeBtn.setBackground(new java.awt.Color(219, 60, 172));
        closeBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("x");
        closeBtn.setBorderColor(new java.awt.Color(219, 60, 172));
        closeBtn.setBorderEnabled(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setColor(new java.awt.Color(219, 60, 172));
        closeBtn.setColorClick(new java.awt.Color(153, 62, 145));
        closeBtn.setColorOver(new java.awt.Color(153, 62, 145));
        closeBtn.setFocusable(false);
        closeBtn.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        closeBtn.setRadius(10);
        closeBtn.addActionListener(this::closeBtnActionPerformed);
        jPanel2.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1850, 20, 40, 39));

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        contentsTabbedPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        startquizPanel.setBackground(new java.awt.Color(53, 48, 128));
        startquizPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructionsLbl.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        instructionsLbl.setForeground(new java.awt.Color(255, 255, 255));
        instructionsLbl.setText("placeholder");
        startquizPanel.add(instructionsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        startQuizBtn.setText("START QUIZ");
        startQuizBtn.setColor1(new java.awt.Color(109, 31, 239));
        startQuizBtn.setColor2(new java.awt.Color(234, 46, 201));
        startQuizBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        startQuizBtn.setHoverColor1(new java.awt.Color(158, 100, 255));
        startQuizBtn.setHoverColor2(new java.awt.Color(244, 105, 220));
        startQuizBtn.setSizeSpeed(1000.0F);
        startQuizBtn.addActionListener(this::startQuizBtnActionPerformed);
        startquizPanel.add(startQuizBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Start Quiz", startquizPanel);

        q1Panel.setBackground(new java.awt.Color(53, 48, 128));
        q1Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q1image.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q1image.setForeground(new java.awt.Color(255, 255, 255));
        q1image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q1image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q1.png"))); // NOI18N
        q1image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q1Panel.add(q1image, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("1. In what year did the Spanish expedition led by Ferdinand Magellan arrive in the Philippines?");
        q1Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        Dq1RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq1RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq1RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq1RadioBtn.setText(" D. 1898");
        q1Panel.add(Dq1RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Aq1RadioBtn.setBackground(new java.awt.Color(52, 47, 128));
        Aq1RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq1RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq1RadioBtn.setText(" A. 1492");
        q1Panel.add(Aq1RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        Bq1RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq1RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq1RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq1RadioBtn.setText(" B. 1521");
        q1Panel.add(Bq1RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Cq1RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq1RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq1RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq1RadioBtn.setText(" C. 1565");
        q1Panel.add(Cq1RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        q1border2.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q1border2.setForeground(new java.awt.Color(255, 255, 255));
        q1border2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q1border2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        q1border2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q1Panel.add(q1border2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        q1border4.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q1border4.setForeground(new java.awt.Color(255, 255, 255));
        q1border4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q1border4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        q1border4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q1Panel.add(q1border4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        q1border1.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q1border1.setForeground(new java.awt.Color(255, 255, 255));
        q1border1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q1border1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        q1border1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q1Panel.add(q1border1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        q1border3.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q1border3.setForeground(new java.awt.Color(255, 255, 255));
        q1border3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q1border3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        q1border3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q1Panel.add(q1border3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn.setText("NEXT");
        next1Btn.setColor1(new java.awt.Color(109, 31, 239));
        next1Btn.setColor2(new java.awt.Color(234, 46, 201));
        next1Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next1Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next1Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next1Btn.setSizeSpeed(1000.0F);
        next1Btn.addActionListener(this::next1BtnActionPerformed);
        q1Panel.add(next1Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q1", q1Panel);

        q2Panel.setBackground(new java.awt.Color(53, 48, 128));
        q2Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq2RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq2RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq2RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq2RadioBtn.setText(" D. Juan de Salcedo");
        q2Panel.add(Dq2RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq2RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq2RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq2RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq2RadioBtn.setText(" C. Andrés de Urdaneta");
        q2Panel.add(Cq2RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq2RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq2RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq2RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq2RadioBtn.setText(" B. Miguel López de Legazpi");
        q2Panel.add(Bq2RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq2RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq2RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq2RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq2RadioBtn.setText(" A. Ferdinand Magellan");
        q2Panel.add(Aq2RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("2. Who led the successful Spanish expedition that established the first permanent settlement in the Philippines in 1565?");
        q2Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn6.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn6.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q2Panel.add(next1Btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn7.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn7.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q2Panel.add(next1Btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn8.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn8.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q2Panel.add(next1Btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn9.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn9.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q2Panel.add(next1Btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        q2image.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q2image.setForeground(new java.awt.Color(255, 255, 255));
        q2image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q2image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q2.png"))); // NOI18N
        q2image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q2Panel.add(q2image, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next2Btn.setText("NEXT");
        next2Btn.setColor1(new java.awt.Color(109, 31, 239));
        next2Btn.setColor2(new java.awt.Color(234, 46, 201));
        next2Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next2Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next2Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next2Btn.setSizeSpeed(1000.0F);
        next2Btn.addActionListener(this::next2BtnActionPerformed);
        q2Panel.add(next2Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q2", q2Panel);

        q3Panel.setBackground(new java.awt.Color(53, 48, 128));
        q3Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq3RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq3RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq3RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq3RadioBtn.setText(" D. Batangas");
        q3Panel.add(Dq3RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, -1));

        Cq3RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq3RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq3RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq3RadioBtn.setText(" C. Cavite");
        q3Panel.add(Cq3RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq3RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq3RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq3RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq3RadioBtn.setText(" B. Cebu");
        q3Panel.add(Bq3RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq3RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq3RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq3RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq3RadioBtn.setText(" A. Manila");
        q3Panel.add(Aq3RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("3. What was the name of the first permanent Spanish settlement in the Philippines?");
        q3Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn10.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn10.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q3Panel.add(next1Btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn11.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn11.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q3Panel.add(next1Btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn12.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn12.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q3Panel.add(next1Btn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn13.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn13.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q3Panel.add(next1Btn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        q3image.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q3image.setForeground(new java.awt.Color(255, 255, 255));
        q3image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q3image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q3.png"))); // NOI18N
        q3image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q3Panel.add(q3image, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next3Btn.setText("NEXT");
        next3Btn.setColor1(new java.awt.Color(109, 31, 239));
        next3Btn.setColor2(new java.awt.Color(234, 46, 201));
        next3Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next3Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next3Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next3Btn.setSizeSpeed(1000.0F);
        next3Btn.addActionListener(this::next3BtnActionPerformed);
        q3Panel.add(next3Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q3", q3Panel);

        q4Panel.setBackground(new java.awt.Color(53, 48, 128));
        q4Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq4RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq4RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq4RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq4RadioBtn.setText(" D. Rajah Matanda");
        q4Panel.add(Dq4RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq4RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq4RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq4RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq4RadioBtn.setText(" C. Lapu-Lapu");
        q4Panel.add(Cq4RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq4RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq4RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq4RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq4RadioBtn.setText(" B. Rajah Sulayman");
        q4Panel.add(Bq4RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq4RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq4RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq4RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq4RadioBtn.setText(" A. Rajah Humabon");
        q4Panel.add(Aq4RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("4. Which native chieftain refused to accept Spanish authority and killed Ferdinand Magellan in the Battle of Mactan in 1521?");
        q4Panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn14.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn14.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q4Panel.add(next1Btn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn15.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn15.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q4Panel.add(next1Btn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn16.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn16.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q4Panel.add(next1Btn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn17.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn17.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q4Panel.add(next1Btn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        q4image.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q4image.setForeground(new java.awt.Color(255, 255, 255));
        q4image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q4image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q4.png"))); // NOI18N
        q4image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q4Panel.add(q4image, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next4tn.setText("NEXT");
        next4tn.setColor1(new java.awt.Color(109, 31, 239));
        next4tn.setColor2(new java.awt.Color(234, 46, 201));
        next4tn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next4tn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next4tn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next4tn.setSizeSpeed(1000.0F);
        next4tn.addActionListener(this::next4tnActionPerformed);
        q4Panel.add(next4tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q4", q4Panel);

        q5Panel.setBackground(new java.awt.Color(53, 48, 128));
        q5Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq5RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq5RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq5RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq5RadioBtn.setText(" D. Political asylum");
        q5Panel.add(Dq5RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq5RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq5RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq5RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq5RadioBtn.setText(" C. Scientific exploration");
        q5Panel.add(Cq5RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq5RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq5RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        Bq5RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq5RadioBtn.setText(" B. God, Gold, and Glory (Christianity, wealth, and power)");
        q5Panel.add(Bq5RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq5RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq5RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq5RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq5RadioBtn.setText(" A.  Gold and spices");
        q5Panel.add(Aq5RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("5. What was the primary reason for Spanish colonization of the Philippines?");
        q5Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn18.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn18.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q5Panel.add(next1Btn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn19.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn19.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q5Panel.add(next1Btn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn20.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn20.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q5Panel.add(next1Btn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn21.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn21.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q5Panel.add(next1Btn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        q5image.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        q5image.setForeground(new java.awt.Color(255, 255, 255));
        q5image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q5image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q5.png"))); // NOI18N
        q5image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q5Panel.add(q5image, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next5Btn.setText("NEXT");
        next5Btn.setColor1(new java.awt.Color(109, 31, 239));
        next5Btn.setColor2(new java.awt.Color(234, 46, 201));
        next5Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next5Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next5Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next5Btn.setSizeSpeed(1000.0F);
        next5Btn.addActionListener(this::next5BtnActionPerformed);
        q5Panel.add(next5Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q5", q5Panel);

        q6Panel.setBackground(new java.awt.Color(53, 48, 128));
        q6Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq6RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq6RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq6RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq6RadioBtn.setText(" D. Polo y Servicio");
        q6Panel.add(Dq6RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq6RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq6RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq6RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq6RadioBtn.setText(" C. Hacienda");
        q6Panel.add(Cq6RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq6RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq6RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq6RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq6RadioBtn.setText(" B. Tribute");
        q6Panel.add(Bq6RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq6RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq6RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq6RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq6RadioBtn.setText(" A.  Encomienda");
        q6Panel.add(Aq6RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("6. What system did the Spanish implement where Filipino natives were required to work for the government without pay?");
        q6Panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn22.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn22.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q6Panel.add(next1Btn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn23.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn23.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q6Panel.add(next1Btn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn24.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn24.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q6Panel.add(next1Btn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn25.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn25.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q6Panel.add(next1Btn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next1Btn74.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn74.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q6.png"))); // NOI18N
        next1Btn74.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q6Panel.add(next1Btn74, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next6Btn.setText("NEXT");
        next6Btn.setColor1(new java.awt.Color(109, 31, 239));
        next6Btn.setColor2(new java.awt.Color(234, 46, 201));
        next6Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next6Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next6Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next6Btn.setSizeSpeed(1000.0F);
        next6Btn.addActionListener(this::next6BtnActionPerformed);
        q6Panel.add(next6Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q6", q6Panel);

        q7Panel.setBackground(new java.awt.Color(53, 48, 128));
        q7Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq7RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq7RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq7RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq7RadioBtn.setText(" D. Mestizos");
        q7Panel.add(Dq7RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq7RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq7RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq7RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq7RadioBtn.setText(" C.  Gobernadorcillos");
        q7Panel.add(Cq7RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq7RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq7RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq7RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq7RadioBtn.setText(" B. Friars");
        q7Panel.add(Bq7RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq7RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq7RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq7RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq7RadioBtn.setText(" A. Encomenderos");
        q7Panel.add(Aq7RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("7. Under the encomienda system, who were granted the right to collect tribute from Filipino natives in exchange for protection and religious instruction?");
        q7Panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn26.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn26.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q7Panel.add(next1Btn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn27.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn27.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q7Panel.add(next1Btn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn28.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn28.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q7Panel.add(next1Btn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn29.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn29.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q7Panel.add(next1Btn29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next1Btn75.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn75.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q7.png"))); // NOI18N
        next1Btn75.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q7Panel.add(next1Btn75, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next7Btn.setText("NEXT");
        next7Btn.setColor1(new java.awt.Color(109, 31, 239));
        next7Btn.setColor2(new java.awt.Color(234, 46, 201));
        next7Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next7Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next7Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next7Btn.setSizeSpeed(1000.0F);
        next7Btn.addActionListener(this::next7BtnActionPerformed);
        q7Panel.add(next7Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q7", q7Panel);

        q8Panel.setBackground(new java.awt.Color(53, 48, 128));
        q8Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq8RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq8RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq8RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq8RadioBtn.setText(" D. All of the above");
        q8Panel.add(Dq8RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq8RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq8RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq8RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq8RadioBtn.setText(" C. Augustinians");
        q8Panel.add(Cq8RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq8RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq8RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq8RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq8RadioBtn.setText(" B. Franciscans");
        q8Panel.add(Bq8RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq8RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq8RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq8RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq8RadioBtn.setText(" A.  Dominicans");
        q8Panel.add(Aq8RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("8. Which religious order played the most significant role in spreading Christianity and education in the Spanish Philippines?");
        q8Panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn30.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn30.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q8Panel.add(next1Btn30, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn31.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn31.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q8Panel.add(next1Btn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn32.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn32.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q8Panel.add(next1Btn32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn33.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn33.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q8Panel.add(next1Btn33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next1Btn76.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn76.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q8.png"))); // NOI18N
        next1Btn76.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q8Panel.add(next1Btn76, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next8Btn.setText("NEXT");
        next8Btn.setColor1(new java.awt.Color(109, 31, 239));
        next8Btn.setColor2(new java.awt.Color(234, 46, 201));
        next8Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next8Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next8Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next8Btn.setSizeSpeed(1000.0F);
        next8Btn.addActionListener(this::next8BtnActionPerformed);
        q8Panel.add(next8Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q8", q8Panel);

        q9Panel.setBackground(new java.awt.Color(53, 48, 128));
        q9Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq9RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq9RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq9RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq9RadioBtn.setText(" D. Spanish Colonial Trade");
        q9Panel.add(Dq9RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq9RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq9RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq9RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq9RadioBtn.setText(" C. Asian-American Exchange");
        q9Panel.add(Cq9RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq9RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq9RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq9RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq9RadioBtn.setText(" B. Pacific Trade Route");
        q9Panel.add(Bq9RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq9RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq9RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq9RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq9RadioBtn.setText(" A. Manila-Acapulco Galleon Trade");
        q9Panel.add(Aq9RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("9. What was the Galleon Trade between the Philippines and Mexico called?");
        q9Panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn34.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn34.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q9Panel.add(next1Btn34, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn35.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn35.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q9Panel.add(next1Btn35, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn36.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn36.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q9Panel.add(next1Btn36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn37.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn37.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q9Panel.add(next1Btn37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next1Btn77.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn77.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q9.png"))); // NOI18N
        next1Btn77.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q9Panel.add(next1Btn77, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next9Btn.setText("NEXT");
        next9Btn.setColor1(new java.awt.Color(109, 31, 239));
        next9Btn.setColor2(new java.awt.Color(234, 46, 201));
        next9Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next9Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next9Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next9Btn.setSizeSpeed(1000.0F);
        next9Btn.addActionListener(this::next9BtnActionPerformed);
        q9Panel.add(next9Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q9", q9Panel);

        q10Panel.setBackground(new java.awt.Color(53, 48, 128));
        q10Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq10RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq10RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq10RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq10RadioBtn.setText(" D. 400 years");
        q10Panel.add(Dq10RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq10RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq10RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq10RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq10RadioBtn.setText(" C. 333 years");
        q10Panel.add(Cq10RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq10RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq10RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq10RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq10RadioBtn.setText(" B. 300 years");
        q10Panel.add(Bq10RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq10RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq10RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq10RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq10RadioBtn.setText(" A. 250 years");
        q10Panel.add(Aq10RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("10. How many years did Spanish colonial rule last in the Philippines?");
        q10Panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn78.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn78.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q10.png"))); // NOI18N
        next1Btn78.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q10Panel.add(next1Btn78, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn86.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn86.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn86.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q10Panel.add(next1Btn86, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn87.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn87.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn87.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q10Panel.add(next1Btn87, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn88.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn88.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn88.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q10Panel.add(next1Btn88, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn89.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn89.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn89.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q10Panel.add(next1Btn89, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next10Btn.setText("NEXT");
        next10Btn.setColor1(new java.awt.Color(109, 31, 239));
        next10Btn.setColor2(new java.awt.Color(234, 46, 201));
        next10Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next10Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next10Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next10Btn.setSizeSpeed(1000.0F);
        next10Btn.addActionListener(this::next10BtnActionPerformed);
        q10Panel.add(next10Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q10", q10Panel);

        q11Panel.setBackground(new java.awt.Color(53, 48, 128));
        q11Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq11RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq11RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq11RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq11RadioBtn.setText(" D.  Apolinario Mabini");
        q11Panel.add(Dq11RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, -1));

        Cq11RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq11RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq11RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq11RadioBtn.setText(" C.  Emilio Aguinaldo");
        q11Panel.add(Cq11RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq11RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq11RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq11RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq11RadioBtn.setText(" B.  Andrés Bonifacio");
        q11Panel.add(Bq11RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq11RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq11RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq11RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq11RadioBtn.setText(" A.  José Rizal");
        q11Panel.add(Aq11RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("11. Who is considered the \"Father of the Katipunan\" and a key leader in the Philippine Revolution against Spain?");
        q11Panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn79.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn79.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q11.png"))); // NOI18N
        next1Btn79.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q11Panel.add(next1Btn79, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn90.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn90.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn90.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q11Panel.add(next1Btn90, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn91.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn91.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn91.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q11Panel.add(next1Btn91, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn92.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn92.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn92.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q11Panel.add(next1Btn92, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn93.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn93.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn93.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q11Panel.add(next1Btn93, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next11Btn.setText("NEXT");
        next11Btn.setColor1(new java.awt.Color(109, 31, 239));
        next11Btn.setColor2(new java.awt.Color(234, 46, 201));
        next11Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next11Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next11Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next11Btn.setSizeSpeed(1000.0F);
        next11Btn.addActionListener(this::next11BtnActionPerformed);
        q11Panel.add(next11Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q11", q11Panel);

        q12Panel.setBackground(new java.awt.Color(53, 48, 128));
        q12Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq12RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq12RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq12RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq12RadioBtn.setText(" D. Sobre la Indolencia de los Filipinos");
        q12Panel.add(Dq12RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq12RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq12RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq12RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq12RadioBtn.setText(" C. Mi Último Adiós");
        q12Panel.add(Cq12RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq12RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq12RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq12RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq12RadioBtn.setText(" B.  Noli Me Tangere");
        q12Panel.add(Bq12RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq12RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq12RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq12RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq12RadioBtn.setText(" A. El Filibusterismo");
        q12Panel.add(Aq12RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("12. What was the name of José Rizal's novel that exposed the abuses of Spanish friars and colonial government?");
        q12Panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn80.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn80.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q12.png"))); // NOI18N
        next1Btn80.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q12Panel.add(next1Btn80, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn94.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn94.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn94.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q12Panel.add(next1Btn94, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn95.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn95.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn95.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q12Panel.add(next1Btn95, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn96.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn96.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn96.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q12Panel.add(next1Btn96, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn97.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn97.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn97.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q12Panel.add(next1Btn97, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next12Btn.setText("NEXT");
        next12Btn.setColor1(new java.awt.Color(109, 31, 239));
        next12Btn.setColor2(new java.awt.Color(234, 46, 201));
        next12Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next12Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next12Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next12Btn.setSizeSpeed(1000.0F);
        next12Btn.addActionListener(this::next12BtnActionPerformed);
        q12Panel.add(next12Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q12", q12Panel);

        q13Panel.setBackground(new java.awt.Color(53, 48, 128));
        q13Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq13RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq13RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq13RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq13RadioBtn.setText(" D. 1896");
        q13Panel.add(Dq13RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq13RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq13RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq13RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq13RadioBtn.setText(" C. 1565");
        q13Panel.add(Cq13RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, -1));

        Bq13RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq13RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq13RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq13RadioBtn.setText(" B. 1898");
        q13Panel.add(Bq13RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, -1));

        Aq13RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq13RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq13RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq13RadioBtn.setText(" A. 1892");
        q13Panel.add(Aq13RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, -1));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("13. In what year was José Rizal executed by the Spanish colonial government?");
        q13Panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn81.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn81.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q13.png"))); // NOI18N
        next1Btn81.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q13Panel.add(next1Btn81, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn98.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn98.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn98.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q13Panel.add(next1Btn98, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn99.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn99.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn99.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q13Panel.add(next1Btn99, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn100.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn100.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn100.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q13Panel.add(next1Btn100, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn101.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn101.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn101.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q13Panel.add(next1Btn101, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next13Btn.setText("NEXT");
        next13Btn.setColor1(new java.awt.Color(109, 31, 239));
        next13Btn.setColor2(new java.awt.Color(234, 46, 201));
        next13Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next13Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next13Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next13Btn.setSizeSpeed(1000.0F);
        next13Btn.addActionListener(this::next13BtnActionPerformed);
        q13Panel.add(next13Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q13", q13Panel);

        q14Panel.setBackground(new java.awt.Color(53, 48, 128));
        q14Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq14RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq14RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq14RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq14RadioBtn.setText(" D. Pact of Biak-na-Bato");
        q14Panel.add(Dq14RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq14RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq14RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq14RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq14RadioBtn.setText(" C. Cavite Mutiny");
        q14Panel.add(Cq14RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq14RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq14RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq14RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq14RadioBtn.setText(" B. Battle of Manila Bay");
        q14Panel.add(Bq14RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq14RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq14RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq14RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq14RadioBtn.setText(" A.  Cry of Pugad Lawin");
        q14Panel.add(Aq14RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("14. What event in 1872 involved the execution of three Filipino priests (Gomburza) and fueled nationalist sentiment?");
        q14Panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn82.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn82.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q14.png"))); // NOI18N
        next1Btn82.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q14Panel.add(next1Btn82, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn102.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn102.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn102.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q14Panel.add(next1Btn102, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn103.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn103.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn103.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q14Panel.add(next1Btn103, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn104.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn104.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn104.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q14Panel.add(next1Btn104, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn105.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn105.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn105.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q14Panel.add(next1Btn105, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next14Btn.setText("START QUIZ");
        next14Btn.setColor1(new java.awt.Color(109, 31, 239));
        next14Btn.setColor2(new java.awt.Color(234, 46, 201));
        next14Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next14Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next14Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next14Btn.setSizeSpeed(1000.0F);
        next14Btn.addActionListener(this::next14BtnActionPerformed);
        q14Panel.add(next14Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 770, 472, 46));

        contentsTabbedPane.addTab("Q14", q14Panel);

        q15Panel.setBackground(new java.awt.Color(53, 48, 128));
        q15Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq15RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq15RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq15RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq15RadioBtn.setText(" D. Treaty of Versailles");
        q15Panel.add(Dq15RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq15RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq15RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq15RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq15RadioBtn.setText(" C.  Pact of Biak-na-Bato");
        q15Panel.add(Cq15RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq15RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq15RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq15RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq15RadioBtn.setText(" B. Treaty of Tordesillas");
        q15Panel.add(Bq15RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq15RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq15RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq15RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq15RadioBtn.setText(" A. Treaty of Paris (1898)");
        q15Panel.add(Aq15RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel17.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("15. Which treaty ended Spanish colonial rule in the Philippines and ceded the islands to the United States?");
        q15Panel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn83.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn83.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q15.png"))); // NOI18N
        next1Btn83.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q15Panel.add(next1Btn83, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn106.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn106.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn106.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q15Panel.add(next1Btn106, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn107.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn107.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn107.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q15Panel.add(next1Btn107, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn108.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn108.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn108.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q15Panel.add(next1Btn108, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn109.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn109.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn109.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q15Panel.add(next1Btn109, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next15Btn.setText("NEXT");
        next15Btn.setColor1(new java.awt.Color(109, 31, 239));
        next15Btn.setColor2(new java.awt.Color(234, 46, 201));
        next15Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next15Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next15Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next15Btn.setSizeSpeed(1000.0F);
        next15Btn.addActionListener(this::next15BtnActionPerformed);
        q15Panel.add(next15Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q15", q15Panel);

        q16Panel.setBackground(new java.awt.Color(53, 48, 128));
        q16Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq16RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq16RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq16RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq16RadioBtn.setText(" D. Ilustrados");
        q16Panel.add(Dq16RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq16RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq16RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq16RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq16RadioBtn.setText(" C. Katipunan (KKK)");
        q16Panel.add(Cq16RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq16RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq16RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq16RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq16RadioBtn.setText(" B. Propaganda Movement");
        q16Panel.add(Bq16RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq16RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq16RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq16RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq16RadioBtn.setText(" A. La Liga Filipina");
        q16Panel.add(Aq16RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("16. What was the name of the secret revolutionary society founded by Andrés Bonifacio in 1892?");
        q16Panel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn84.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn84.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q16.png"))); // NOI18N
        next1Btn84.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q16Panel.add(next1Btn84, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn110.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn110.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn110.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q16Panel.add(next1Btn110, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn111.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn111.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn111.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q16Panel.add(next1Btn111, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn112.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn112.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn112.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q16Panel.add(next1Btn112, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn113.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn113.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn113.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q16Panel.add(next1Btn113, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next16Btn.setText("NEXT");
        next16Btn.setColor1(new java.awt.Color(109, 31, 239));
        next16Btn.setColor2(new java.awt.Color(234, 46, 201));
        next16Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next16Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next16Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next16Btn.setSizeSpeed(1000.0F);
        next16Btn.addActionListener(this::next16BtnActionPerformed);
        q16Panel.add(next16Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q16", q16Panel);

        q17Panel.setBackground(new java.awt.Color(53, 48, 128));
        q17Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dq17RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Dq17RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Dq17RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Dq17RadioBtn.setText(" D. Calamba, Laguna");
        q17Panel.add(Dq17RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 470, 30));

        Cq17RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Cq17RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Cq17RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Cq17RadioBtn.setText(" C. Kawit, Cavite");
        q17Panel.add(Cq17RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 470, 30));

        Bq17RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Bq17RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Bq17RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Bq17RadioBtn.setText(" B. Malolos, Bulacan");
        q17Panel.add(Bq17RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 470, 30));

        Aq17RadioBtn.setBackground(new java.awt.Color(53, 48, 128));
        Aq17RadioBtn.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        Aq17RadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Aq17RadioBtn.setText(" A. Manila");
        q17Panel.add(Aq17RadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 470, 30));

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("17. Where did Emilio Aguinaldo declare Philippine independence from Spain on June 12, 1898?");
        q17Panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        next1Btn85.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn85.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/Q17.png"))); // NOI18N
        next1Btn85.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q17Panel.add(next1Btn85, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 80, -1, -1));

        next1Btn114.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn114.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn114.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q17Panel.add(next1Btn114, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        next1Btn115.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn115.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn115.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q17Panel.add(next1Btn115, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, -1, -1));

        next1Btn116.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn116.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn116.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q17Panel.add(next1Btn116, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, -1, -1));

        next1Btn117.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        next1Btn117.setForeground(new java.awt.Color(255, 255, 255));
        next1Btn117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next1Btn117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/radio-button-border.png"))); // NOI18N
        next1Btn117.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        q17Panel.add(next1Btn117, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, -1));

        next17Btn.setText("NEXT");
        next17Btn.setColor1(new java.awt.Color(109, 31, 239));
        next17Btn.setColor2(new java.awt.Color(234, 46, 201));
        next17Btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        next17Btn.setHoverColor1(new java.awt.Color(158, 100, 255));
        next17Btn.setHoverColor2(new java.awt.Color(244, 105, 220));
        next17Btn.setSizeSpeed(1000.0F);
        next17Btn.addActionListener(this::next17BtnActionPerformed);
        q17Panel.add(next17Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 770, 472, 46));

        contentsTabbedPane.addTab("Q17", q17Panel);

        resultPanel.setBackground(new java.awt.Color(53, 48, 128));
        resultPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(53, 48, 128));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Score:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        scoreLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        scoreLbl.setForeground(new java.awt.Color(255, 255, 255));
        scoreLbl.setText("score here");
        jPanel1.add(scoreLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel22.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Percentage:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        percentageLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        percentageLbl.setForeground(new java.awt.Color(255, 255, 255));
        percentageLbl.setText("percentage here");
        jPanel1.add(percentageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jLabel23.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Remark:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        remarkLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        remarkLbl.setForeground(new java.awt.Color(255, 255, 255));
        remarkLbl.setText("remark here");
        jPanel1.add(remarkLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Recommendation:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        recommendationLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        recommendationLbl.setForeground(new java.awt.Color(255, 255, 255));
        recommendationLbl.setText("placeholder");
        recommendationLbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(recommendationLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 340, 360));

        resultPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 360, 560));

        jLabel21.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("QUIZ TAKERS");
        resultPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 30, -1, -1));

        jPanel3.setBackground(new java.awt.Color(53, 48, 128));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q17AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q17AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q17AnsLbl.setText("q17 ans");
        jPanel3.add(q17AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, -1, -1));

        jLabel27.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Question 2: ");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel28.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Question 3: ");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel29.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Question 4: ");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel30.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Question 5: ");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel31.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Question 6: ");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Question 7: ");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel33.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Question 8: ");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel34.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Question 9: ");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel35.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Question 10: ");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jLabel36.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Question 11: ");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel37.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Question 12: ");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        jLabel38.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Question 13: ");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, -1));

        jLabel39.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Question 14: ");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jLabel40.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Question 15: ");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));

        jLabel41.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Question 16: ");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        jLabel42.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Question 17: ");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, -1, -1));

        q17EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q17EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q17EvalLbl.setText("???");
        jPanel3.add(q17EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, -1, -1));

        jLabel44.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Question 1: ");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        q1AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q1AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q1AnsLbl.setText("q1 ans");
        jPanel3.add(q1AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        q2AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q2AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q2AnsLbl.setText("q2 ans");
        jPanel3.add(q2AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        q3AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q3AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q3AnsLbl.setText("q3 ans");
        jPanel3.add(q3AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        q4AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q4AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q4AnsLbl.setText("q4 ans");
        jPanel3.add(q4AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        q5AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q5AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q5AnsLbl.setText("q5 ans");
        jPanel3.add(q5AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        q6AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q6AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q6AnsLbl.setText("q6 ans");
        jPanel3.add(q6AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        q7AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q7AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q7AnsLbl.setText("q7 ans");
        jPanel3.add(q7AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        q8AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q8AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q8AnsLbl.setText("q8 ans");
        jPanel3.add(q8AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        q9AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q9AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q9AnsLbl.setText("q9 ans");
        jPanel3.add(q9AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        q10AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q10AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q10AnsLbl.setText("q10 ans");
        jPanel3.add(q10AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        q11AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q11AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q11AnsLbl.setText("q11 ans");
        jPanel3.add(q11AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        q12AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q12AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q12AnsLbl.setText("q12 ans");
        jPanel3.add(q12AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        q13AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q13AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q13AnsLbl.setText("q13 ans");
        jPanel3.add(q13AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        q14AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q14AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q14AnsLbl.setText("q14 ans");
        jPanel3.add(q14AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, -1, -1));

        q15AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q15AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q15AnsLbl.setText("q15 ans");
        jPanel3.add(q15AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        q16AnsLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q16AnsLbl.setForeground(new java.awt.Color(255, 255, 255));
        q16AnsLbl.setText("q16 ans");
        jPanel3.add(q16AnsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, -1, -1));

        q1EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q1EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q1EvalLbl.setText("???");
        jPanel3.add(q1EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        q2EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q2EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q2EvalLbl.setText("???");
        jPanel3.add(q2EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        q3EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q3EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q3EvalLbl.setText("???");
        jPanel3.add(q3EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        q4EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q4EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q4EvalLbl.setText("???");
        jPanel3.add(q4EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        q5EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q5EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q5EvalLbl.setText("???");
        jPanel3.add(q5EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        q6EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q6EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q6EvalLbl.setText("???");
        jPanel3.add(q6EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        q7EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q7EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q7EvalLbl.setText("???");
        jPanel3.add(q7EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, -1));

        q8EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q8EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q8EvalLbl.setText("???");
        jPanel3.add(q8EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        q9EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q9EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q9EvalLbl.setText("???");
        jPanel3.add(q9EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        q10EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q10EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q10EvalLbl.setText("???");
        jPanel3.add(q10EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        q11EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q11EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q11EvalLbl.setText("???");
        jPanel3.add(q11EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        q12EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q12EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q12EvalLbl.setText("???");
        jPanel3.add(q12EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        q13EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q13EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q13EvalLbl.setText("???");
        jPanel3.add(q13EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        q14EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q14EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q14EvalLbl.setText("???");
        jPanel3.add(q14EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        q15EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q15EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q15EvalLbl.setText("???");
        jPanel3.add(q15EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, -1, -1));

        q16EvalLbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        q16EvalLbl.setForeground(new java.awt.Color(255, 255, 255));
        q16EvalLbl.setText("???");
        jPanel3.add(q16EvalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));

        resultPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 630, 560));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Score", "Percentage", "Remark"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        resultPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 120, 480, 560));

        goToDashboardBtn.setText("GO TO DASHBOARD");
        goToDashboardBtn.setColor1(new java.awt.Color(109, 31, 239));
        goToDashboardBtn.setColor2(new java.awt.Color(234, 46, 201));
        goToDashboardBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        goToDashboardBtn.setHoverColor1(new java.awt.Color(158, 100, 255));
        goToDashboardBtn.setHoverColor2(new java.awt.Color(244, 105, 220));
        goToDashboardBtn.addActionListener(this::goToDashboardBtnActionPerformed);
        resultPanel.add(goToDashboardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 770, 250, 46));

        retakeQuizBtn.setText("RETAKE QUIZ");
        retakeQuizBtn.setColor1(new java.awt.Color(109, 31, 239));
        retakeQuizBtn.setColor2(new java.awt.Color(234, 46, 201));
        retakeQuizBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        retakeQuizBtn.setHoverColor1(new java.awt.Color(158, 100, 255));
        retakeQuizBtn.setHoverColor2(new java.awt.Color(244, 105, 220));
        retakeQuizBtn.addActionListener(this::retakeQuizBtnActionPerformed);
        resultPanel.add(retakeQuizBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 770, 250, 46));

        leftSideBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/left-side-border.png"))); // NOI18N
        resultPanel.add(leftSideBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/middel-border.png"))); // NOI18N
        resultPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        jLabel26.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("RESULT");
        resultPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/right-side-border.png"))); // NOI18N
        resultPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 100, -1, -1));

        jLabel45.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("SUMMARY");
        resultPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        contentsTabbedPane.addTab("Result", resultPanel);

        mainPanel.add(contentsTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 160, 1886, 900));

        titleLbl.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(230, 238, 248));
        titleLbl.setText("Placeholder");
        mainPanel.add(titleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 95, -1, -1));

        timerLbl.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        timerLbl.setForeground(new java.awt.Color(255, 255, 255));
        timerLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/icons/timer-button.png"))); // NOI18N
        timerLbl.setText("00:00");
        timerLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        timerLbl.setIconTextGap(0);
        mainPanel.add(timerLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1786, 110, -1, -1));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startQuizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startQuizBtnActionPerformed
        StartQuiz();
        TextPlaceholder(1);
    }//GEN-LAST:event_startQuizBtnActionPerformed

    private void next1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1BtnActionPerformed
        boolean eval = Evaluate(Bq1RadioBtn , q2Panel); 
        DisplaySummary(eval, q1, q1AnsLbl, q1EvalLbl);
        TextPlaceholder(2);
    }//GEN-LAST:event_next1BtnActionPerformed

    private void next2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next2BtnActionPerformed
        boolean eval = Evaluate(Bq2RadioBtn , q3Panel); 
        DisplaySummary(eval, q2, q2AnsLbl, q2EvalLbl);
        TextPlaceholder(3);
    }//GEN-LAST:event_next2BtnActionPerformed

    private void next3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next3BtnActionPerformed
        boolean eval = Evaluate(Bq3RadioBtn , q4Panel);
        DisplaySummary(eval, q3, q3AnsLbl, q3EvalLbl);
        TextPlaceholder(4);
    }//GEN-LAST:event_next3BtnActionPerformed

    private void next4tnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next4tnActionPerformed
        boolean eval = Evaluate(Cq4RadioBtn , q5Panel);
        DisplaySummary(eval, q4, q4AnsLbl, q4EvalLbl);
        TextPlaceholder(5);
    }//GEN-LAST:event_next4tnActionPerformed

    private void next5BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next5BtnActionPerformed
        boolean eval = Evaluate(Bq5RadioBtn , q6Panel);
        DisplaySummary(eval, q5, q5AnsLbl, q5EvalLbl);
        TextPlaceholder(6);
    }//GEN-LAST:event_next5BtnActionPerformed

    private void next6BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next6BtnActionPerformed
        boolean eval = Evaluate(Dq6RadioBtn , q7Panel);
        DisplaySummary(eval, q6, q6AnsLbl, q6EvalLbl);
        TextPlaceholder(7);
    }//GEN-LAST:event_next6BtnActionPerformed

    private void next7BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next7BtnActionPerformed
        boolean eval = Evaluate(Aq7RadioBtn , q8Panel);
        DisplaySummary(eval, q7, q7AnsLbl, q7EvalLbl);
        TextPlaceholder(8);
    }//GEN-LAST:event_next7BtnActionPerformed

    private void next8BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next8BtnActionPerformed
        boolean eval = Evaluate(Dq8RadioBtn , q9Panel);
        DisplaySummary(eval, q8, q8AnsLbl, q8EvalLbl);
        TextPlaceholder(9);
    }//GEN-LAST:event_next8BtnActionPerformed

    private void next9BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next9BtnActionPerformed
        boolean eval = Evaluate(Aq9RadioBtn , q10Panel);
        DisplaySummary(eval, q9, q9AnsLbl, q9EvalLbl);
        TextPlaceholder(10);
    }//GEN-LAST:event_next9BtnActionPerformed

    private void next10BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next10BtnActionPerformed
        boolean eval = Evaluate(Cq10RadioBtn , q11Panel);
        DisplaySummary(eval, q10, q10AnsLbl, q10EvalLbl);
        TextPlaceholder(11);
    }//GEN-LAST:event_next10BtnActionPerformed

    private void next11BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next11BtnActionPerformed
        boolean eval = Evaluate(Bq11RadioBtn , q12Panel);
        DisplaySummary(eval, q11, q11AnsLbl, q11EvalLbl);
        TextPlaceholder(12);
    }//GEN-LAST:event_next11BtnActionPerformed

    private void next12BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next12BtnActionPerformed
        boolean eval = Evaluate(Bq12RadioBtn , q13Panel);
        DisplaySummary(eval, q12, q12AnsLbl, q12EvalLbl);
        TextPlaceholder(13);
    }//GEN-LAST:event_next12BtnActionPerformed

    private void next13BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next13BtnActionPerformed
        boolean eval = Evaluate(Dq13RadioBtn , q14Panel);
        DisplaySummary(eval, q13, q13AnsLbl, q13EvalLbl);
        TextPlaceholder(14);
    }//GEN-LAST:event_next13BtnActionPerformed

    private void next14BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next14BtnActionPerformed
        boolean eval = Evaluate(Cq14RadioBtn , q15Panel);
        DisplaySummary(eval, q14, q14AnsLbl, q14EvalLbl);
        TextPlaceholder(15);
    }//GEN-LAST:event_next14BtnActionPerformed

    private void next15BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next15BtnActionPerformed
        boolean eval = Evaluate(Aq15RadioBtn , q16Panel);
        DisplaySummary(eval, q15, q15AnsLbl, q15EvalLbl);
        TextPlaceholder(16);
    }//GEN-LAST:event_next15BtnActionPerformed

    private void next16BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next16BtnActionPerformed
        boolean eval = Evaluate(Cq16RadioBtn , q17Panel);
        DisplaySummary(eval, q16, q16AnsLbl, q16EvalLbl);
        TextPlaceholder(17);
    }//GEN-LAST:event_next16BtnActionPerformed

    private void next17BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next17BtnActionPerformed
        boolean isCorrect = CheckIfAnswerIsCorrect(Cq17RadioBtn);
        DisplaySummary(isCorrect, q17, q17AnsLbl, q17EvalLbl);
        AddScore(isCorrect);
        MessaageBox(isCorrect);
        currentlyTakingQuiz = false;
        stopTimer();
        Result();
        titleLbl.setText("RESULT");
        Tabs(resultPanel);
//        ResetSummary();
    }//GEN-LAST:event_next17BtnActionPerformed

// ============================================================================================================================        
    
    private void retakeQuizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retakeQuizBtnActionPerformed
        ResetAll();
        StartQuiz();
    }//GEN-LAST:event_retakeQuizBtnActionPerformed

    private void goToDashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToDashboardBtnActionPerformed
        ResetAll();
        NavigationUtil.switchFrame(this, parent);
    }//GEN-LAST:event_goToDashboardBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        if(currentlyTakingQuiz){
            int result = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit? Your progress will be lost.",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            
            if(result == JOptionPane.YES_OPTION){
                ResetAll();
                NavigationUtil.switchFrame(this, parent);
            }
        }
        NavigationUtil.switchFrame(this, parent);
    }//GEN-LAST:event_backBtnActionPerformed

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        UIUtils.minimizeFrame(this);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        if(currentlyTakingQuiz){
            UIUtils.closeFrame(this, "Are you sure you want to exit? Your progress will be lost.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else {
            UIUtils.closeFrame(this, "Are you sure you want to exit?", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

   
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
        //java.awt.EventQueue.invokeLater(() -> new QuizUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Aq10RadioBtn;
    private javax.swing.JRadioButton Aq11RadioBtn;
    private javax.swing.JRadioButton Aq12RadioBtn;
    private javax.swing.JRadioButton Aq13RadioBtn;
    private javax.swing.JRadioButton Aq14RadioBtn;
    private javax.swing.JRadioButton Aq15RadioBtn;
    private javax.swing.JRadioButton Aq16RadioBtn;
    private javax.swing.JRadioButton Aq17RadioBtn;
    private javax.swing.JRadioButton Aq1RadioBtn;
    private javax.swing.JRadioButton Aq2RadioBtn;
    private javax.swing.JRadioButton Aq3RadioBtn;
    private javax.swing.JRadioButton Aq4RadioBtn;
    private javax.swing.JRadioButton Aq5RadioBtn;
    private javax.swing.JRadioButton Aq6RadioBtn;
    private javax.swing.JRadioButton Aq7RadioBtn;
    private javax.swing.JRadioButton Aq8RadioBtn;
    private javax.swing.JRadioButton Aq9RadioBtn;
    private javax.swing.JRadioButton Bq10RadioBtn;
    private javax.swing.JRadioButton Bq11RadioBtn;
    private javax.swing.JRadioButton Bq12RadioBtn;
    private javax.swing.JRadioButton Bq13RadioBtn;
    private javax.swing.JRadioButton Bq14RadioBtn;
    private javax.swing.JRadioButton Bq15RadioBtn;
    private javax.swing.JRadioButton Bq16RadioBtn;
    private javax.swing.JRadioButton Bq17RadioBtn;
    private javax.swing.JRadioButton Bq1RadioBtn;
    private javax.swing.JRadioButton Bq2RadioBtn;
    private javax.swing.JRadioButton Bq3RadioBtn;
    private javax.swing.JRadioButton Bq4RadioBtn;
    private javax.swing.JRadioButton Bq5RadioBtn;
    private javax.swing.JRadioButton Bq6RadioBtn;
    private javax.swing.JRadioButton Bq7RadioBtn;
    private javax.swing.JRadioButton Bq8RadioBtn;
    private javax.swing.JRadioButton Bq9RadioBtn;
    private javax.swing.JRadioButton Cq10RadioBtn;
    private javax.swing.JRadioButton Cq11RadioBtn;
    private javax.swing.JRadioButton Cq12RadioBtn;
    private javax.swing.JRadioButton Cq13RadioBtn;
    private javax.swing.JRadioButton Cq14RadioBtn;
    private javax.swing.JRadioButton Cq15RadioBtn;
    private javax.swing.JRadioButton Cq16RadioBtn;
    private javax.swing.JRadioButton Cq17RadioBtn;
    private javax.swing.JRadioButton Cq1RadioBtn;
    private javax.swing.JRadioButton Cq2RadioBtn;
    private javax.swing.JRadioButton Cq3RadioBtn;
    private javax.swing.JRadioButton Cq4RadioBtn;
    private javax.swing.JRadioButton Cq5RadioBtn;
    private javax.swing.JRadioButton Cq6RadioBtn;
    private javax.swing.JRadioButton Cq7RadioBtn;
    private javax.swing.JRadioButton Cq8RadioBtn;
    private javax.swing.JRadioButton Cq9RadioBtn;
    private javax.swing.JRadioButton Dq10RadioBtn;
    private javax.swing.JRadioButton Dq11RadioBtn;
    private javax.swing.JRadioButton Dq12RadioBtn;
    private javax.swing.JRadioButton Dq13RadioBtn;
    private javax.swing.JRadioButton Dq14RadioBtn;
    private javax.swing.JRadioButton Dq15RadioBtn;
    private javax.swing.JRadioButton Dq16RadioBtn;
    private javax.swing.JRadioButton Dq17RadioBtn;
    private javax.swing.JRadioButton Dq1RadioBtn;
    private javax.swing.JRadioButton Dq2RadioBtn;
    private javax.swing.JRadioButton Dq3RadioBtn;
    private javax.swing.JRadioButton Dq4RadioBtn;
    private javax.swing.JRadioButton Dq5RadioBtn;
    private javax.swing.JRadioButton Dq6RadioBtn;
    private javax.swing.JRadioButton Dq7RadioBtn;
    private javax.swing.JRadioButton Dq8RadioBtn;
    private javax.swing.JRadioButton Dq9RadioBtn;
    private commons.RoundButton backBtn;
    private commons.RoundButton closeBtn;
    private javax.swing.JTabbedPane contentsTabbedPane;
    private commons.GradientButton goToDashboardBtn;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel leftSideBorder;
    private javax.swing.JPanel mainPanel;
    private commons.RoundButton minimizeBtn;
    private commons.GradientButton next10Btn;
    private commons.GradientButton next11Btn;
    private commons.GradientButton next12Btn;
    private commons.GradientButton next13Btn;
    private commons.GradientButton next14Btn;
    private commons.GradientButton next15Btn;
    private commons.GradientButton next16Btn;
    private commons.GradientButton next17Btn;
    private commons.GradientButton next1Btn;
    private javax.swing.JLabel next1Btn10;
    private javax.swing.JLabel next1Btn100;
    private javax.swing.JLabel next1Btn101;
    private javax.swing.JLabel next1Btn102;
    private javax.swing.JLabel next1Btn103;
    private javax.swing.JLabel next1Btn104;
    private javax.swing.JLabel next1Btn105;
    private javax.swing.JLabel next1Btn106;
    private javax.swing.JLabel next1Btn107;
    private javax.swing.JLabel next1Btn108;
    private javax.swing.JLabel next1Btn109;
    private javax.swing.JLabel next1Btn11;
    private javax.swing.JLabel next1Btn110;
    private javax.swing.JLabel next1Btn111;
    private javax.swing.JLabel next1Btn112;
    private javax.swing.JLabel next1Btn113;
    private javax.swing.JLabel next1Btn114;
    private javax.swing.JLabel next1Btn115;
    private javax.swing.JLabel next1Btn116;
    private javax.swing.JLabel next1Btn117;
    private javax.swing.JLabel next1Btn12;
    private javax.swing.JLabel next1Btn13;
    private javax.swing.JLabel next1Btn14;
    private javax.swing.JLabel next1Btn15;
    private javax.swing.JLabel next1Btn16;
    private javax.swing.JLabel next1Btn17;
    private javax.swing.JLabel next1Btn18;
    private javax.swing.JLabel next1Btn19;
    private javax.swing.JLabel next1Btn20;
    private javax.swing.JLabel next1Btn21;
    private javax.swing.JLabel next1Btn22;
    private javax.swing.JLabel next1Btn23;
    private javax.swing.JLabel next1Btn24;
    private javax.swing.JLabel next1Btn25;
    private javax.swing.JLabel next1Btn26;
    private javax.swing.JLabel next1Btn27;
    private javax.swing.JLabel next1Btn28;
    private javax.swing.JLabel next1Btn29;
    private javax.swing.JLabel next1Btn30;
    private javax.swing.JLabel next1Btn31;
    private javax.swing.JLabel next1Btn32;
    private javax.swing.JLabel next1Btn33;
    private javax.swing.JLabel next1Btn34;
    private javax.swing.JLabel next1Btn35;
    private javax.swing.JLabel next1Btn36;
    private javax.swing.JLabel next1Btn37;
    private javax.swing.JLabel next1Btn6;
    private javax.swing.JLabel next1Btn7;
    private javax.swing.JLabel next1Btn74;
    private javax.swing.JLabel next1Btn75;
    private javax.swing.JLabel next1Btn76;
    private javax.swing.JLabel next1Btn77;
    private javax.swing.JLabel next1Btn78;
    private javax.swing.JLabel next1Btn79;
    private javax.swing.JLabel next1Btn8;
    private javax.swing.JLabel next1Btn80;
    private javax.swing.JLabel next1Btn81;
    private javax.swing.JLabel next1Btn82;
    private javax.swing.JLabel next1Btn83;
    private javax.swing.JLabel next1Btn84;
    private javax.swing.JLabel next1Btn85;
    private javax.swing.JLabel next1Btn86;
    private javax.swing.JLabel next1Btn87;
    private javax.swing.JLabel next1Btn88;
    private javax.swing.JLabel next1Btn89;
    private javax.swing.JLabel next1Btn9;
    private javax.swing.JLabel next1Btn90;
    private javax.swing.JLabel next1Btn91;
    private javax.swing.JLabel next1Btn92;
    private javax.swing.JLabel next1Btn93;
    private javax.swing.JLabel next1Btn94;
    private javax.swing.JLabel next1Btn95;
    private javax.swing.JLabel next1Btn96;
    private javax.swing.JLabel next1Btn97;
    private javax.swing.JLabel next1Btn98;
    private javax.swing.JLabel next1Btn99;
    private commons.GradientButton next2Btn;
    private commons.GradientButton next3Btn;
    private commons.GradientButton next4tn;
    private commons.GradientButton next5Btn;
    private commons.GradientButton next6Btn;
    private commons.GradientButton next7Btn;
    private commons.GradientButton next8Btn;
    private commons.GradientButton next9Btn;
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
    private javax.swing.JLabel q1border1;
    private javax.swing.JLabel q1border2;
    private javax.swing.JLabel q1border3;
    private javax.swing.JLabel q1border4;
    private javax.swing.JLabel q1image;
    private javax.swing.JLabel q2AnsLbl;
    private javax.swing.JLabel q2EvalLbl;
    private javax.swing.JPanel q2Panel;
    private javax.swing.JLabel q2image;
    private javax.swing.JLabel q3AnsLbl;
    private javax.swing.JLabel q3EvalLbl;
    private javax.swing.JPanel q3Panel;
    private javax.swing.JLabel q3image;
    private javax.swing.JLabel q4AnsLbl;
    private javax.swing.JLabel q4EvalLbl;
    private javax.swing.JPanel q4Panel;
    private javax.swing.JLabel q4image;
    private javax.swing.JLabel q5AnsLbl;
    private javax.swing.JLabel q5EvalLbl;
    private javax.swing.JPanel q5Panel;
    private javax.swing.JLabel q5image;
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
    private javax.swing.JLabel recommendationLbl;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JPanel resultPanel;
    private commons.GradientButton retakeQuizBtn;
    private javax.swing.JLabel scoreLbl;
    private commons.GradientButton startQuizBtn;
    private javax.swing.JPanel startquizPanel;
    private javax.swing.JLabel timerLbl;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
