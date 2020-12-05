import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;


import java.io.*;

public class UI implements ActionListener {

   private final JFrame frame;
   /***
    * JFrame.
    */

   private final JPanel panel;
   /***
    * JPanel.
    */
   private final JPanel panelSub1;
   /***
    * JPanel.
    */
   private final JPanel panelSub2;
   /***
    * JPanel.
    */
   private final JPanel panelSub3;
   /***
    * JPanel.
    */
   private final JPanel panelSub4;
   /***
    * JPanel.
    */
   private final JPanel panelSub5;
   /***
    * JPanel.
    */
   private final JPanel panelSub6;
   /***
    * JPanel.
    */
   private final JPanel panelSub7;
   /***
    * JPanel.
    */
   private final JPanel panelSub8;
   /***
    * JPanel.
    */

   private final JTextArea text;
   /***
    * JTextArea.
    */
   private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
      butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
      butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary;
   /***
    * JButton.
    */
   private final Calculator calc;
   /***
    * Calculator calc.
    */

   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
      "7", "8", "9"};
   /***
    * buttonValue.
    */

   private final Font font;
   /***
    * Font font.
    */
   private final Font textFont;
   /***
    * Font textFont.
    * @throws IOException
    */


   public UI() throws IOException {
      /***
       * UI.
       */
      frame = new JFrame("Calculator PH");


      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());

      final int sspp = 18;
      font = new Font("Consolas", Font.PLAIN, sspp);

      final int ttyy = 30;
      text = new JTextArea(1, ttyy);

      final int ttff = 24;
      textFont = new Font("Consolas", Font.BOLD, ttff);

      final int tteenn = 10;

      but = new JButton[tteenn];
      for (int i = 0; i < tteenn; i++) {
         but[i] = new JButton(String.valueOf(i));
      }
      butAdd = new JButton("+");
      butMinus = new JButton("-");
      butMultiply = new JButton("*");
      butDivide = new JButton("/");
      butEqual = new JButton("=");
      butSquareRoot = new JButton("sqrt");
      butSquare = new JButton("x*x");
      butOneDevidedBy = new JButton("1/x");
      butCos = new JButton("Cos");
      butSin = new JButton("Sin");
      butTan = new JButton("Tan");
      butxpowerofy = new JButton("x^y");
      butlog = new JButton("log10(x)");
      butrate = new JButton("x%");
      butabs = new JButton("abs(x)");
      butCancel = new JButton("C");
      butBinary = new JButton("Bin");

      calc = new Calculator();

   }

   public void init() {
      /***
       * init.
       */
      final int tft = 450;

      frame.setSize(tft, tft);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      text.setFont(textFont);
      text.setEditable(false);

      final int tteenn = 10;
      for (int i = 0; i < tteenn; i++) {
         but[i].setFont(font);
      }
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDevidedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font);

      panel.add(Box.createHorizontalStrut(tteenn*tteenn));
      panelSub1.add(text);
      panel.add(panelSub1);

      panelSub2.add(but[1]);
      panelSub2.add(but[2]);
      panelSub2.add(but[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);

      panelSub3.add(but[4]);
      panelSub3.add(but[5]);
      panelSub3.add(but[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);
      panel.add(panelSub3);

      panelSub4.add(but[7]);
      panelSub4.add(but[8]);
      panelSub4.add(but[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);

      panelSub5.add(but[0]);
      panelSub5.add(Box.createHorizontalStrut(210));
      panel.add(panelSub5);

      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDevidedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);

      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panel.add(panelSub7);

      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);

      for (int i = 0; i < tteenn; i++) {
         but[i].addActionListener(this);
      }
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDevidedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);

      butEqual.addActionListener(this);
      butCancel.addActionListener(this);

      frame.add(panel);
   }

   @Override
   public void actionPerformed(final ActionEvent e) {
      final Object source = e.getSource();
      final int tteenn = 10;

      for (int i = 0; i < tteenn; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }

      if (source == butAdd) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.ADD, reader()));
      }

      if (source == butMinus) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.MINUS, reader()));
      }

      if (source == butMultiply) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY,
                                 reader()));
      }

      if (source == butDivide) {
         writer(calc
                   .calculateBi(Calculator.BiOperatorModes.DIVIDE, reader()));
      }
      if (source == butxpowerofy) {
         writer(calc
                   .calculateBi(Calculator.BiOperatorModes.
                           XPOWEROFY, reader()));
      }

      if (source == butSquare) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE,
                                   reader()));
      }

      if (source == butSquareRoot) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT,
                                   reader()));
      }

      if (source == butOneDevidedBy) {
         writer(calc.calculateMono(
                                   Calculator.MonoOperatorModes.ONEDEVIDEDBY,
                 reader()));
      }

      if (source == butCos) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.COS,
                                   reader()));
      }

      if (source == butSin) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SIN,
                                   reader()));
      }

      if (source == butTan) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.TAN,
                                   reader()));
      }
      if (source == butlog) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.LOG,
                                   reader()));
      }
      if (source == butrate) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.RATE,
                                   reader()));
      }
      if (source == butabs) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.ABS, reader()));
      }

      if (source == butEqual) {
         writer(calc.calculateEqual(reader()));
      }

      if (source == butCancel) {
         writer(calc.reset());
      }

      if (source == butBinary) {
         parsetoBinary();
      }

      text.selectAll();
   }

   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }

   public Double reader() {
      /***
       * reader.
       */
      Double num;
      String str;
      str = text.getText();
      num = Double.valueOf(str);

      return num;
   }

   public void writer(final Double num) {
      /***
       * writer.
       */
      if (Double.isNaN(num)) {
         text.setText("");
      } else {
         text.setText(Double.toString(num));
      }
   }
}
