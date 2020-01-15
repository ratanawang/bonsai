package bonsai;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BonsaiFrame extends javax.swing.JFrame {
    
    //variables
    private String word;  //pick random word from list
    private String guess;
    private int lives;
    private int coins;
    private final String[] imgs;
    private WordManager wm = new WordManager();

    public BonsaiFrame() {
        this.imgs = new String[]{"images/bonsai-dead.png", "images/bonsai-1.png", 
            "images/bonsai-2.png", "images/bonsai-3.png", "images/bonsai-4.png", 
            "images/bonsai-5.png"};
        initComponents();
        startNewGame();
        textInfo.setText("Welcome to Bonsai.\nPlease keep your bonsai tree alive!\n"
                + "Collect coins and buy a fertilizer (a hint) or a new bonsai\n"
                + "tree (restart without losing coins) if you get stuck!");
    }
    
    public static String getShowWord(String w, String g) {
        //return what the user should see!
        String newstring = "";
        for (int i = 0; i < w.length(); i ++) {
            if (g.contains(w.substring(i, i + 1))) {
                newstring += w.substring(i, i + 1);
            }
            else {
                newstring += "-";
            }
        }
        return newstring;
    }
    
    public void drawBonsai() {
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource(imgs[lives]));
        Image img = icon.getImage();
        img = img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
        labelImage.setIcon(new ImageIcon(img));
    }
    
    public void startNewGame() {
        coins = 0;
        lives = 5;
        word = wm.getWord();
        guess = "";
        textInfo.setText("New game started. Good luck!");
        textWord.setText(getShowWord(word, guess));
        drawBonsai();
        money();
        allButtons(true);
    }
    
    public void winner() {
        coins += 5;
        money();
        allButtons(true);
        lives = 5;
        drawBonsai();
        String oldWord = word;
        word = wm.getWord();
        guess = "";
        textInfo.setText("Congratulations! You guessed the word.\nIt was "
                + oldWord + ".\nYou've earned 5 coins. Play on!");
        textWord.setText(getShowWord(word, guess));
    }
    
    public void allButtons(boolean onf) {
        buttonA.setEnabled(onf);
        buttonB.setEnabled(onf);
        buttonC.setEnabled(onf);
        buttonD.setEnabled(onf);
        buttonE.setEnabled(onf);
        buttonF.setEnabled(onf);
        buttonG.setEnabled(onf);
        buttonH.setEnabled(onf);
        buttonI.setEnabled(onf);
        buttonJ.setEnabled(onf);
        buttonK.setEnabled(onf);
        buttonL.setEnabled(onf);
        buttonM.setEnabled(onf);
        buttonN.setEnabled(onf);
        buttonO.setEnabled(onf);
        buttonP.setEnabled(onf);
        buttonQ.setEnabled(onf);
        buttonR.setEnabled(onf);
        buttonS.setEnabled(onf);
        buttonT.setEnabled(onf);
        buttonU.setEnabled(onf);
        buttonV.setEnabled(onf);
        buttonW.setEnabled(onf);
        buttonX.setEnabled(onf);
        buttonY.setEnabled(onf);
        buttonZ.setEnabled(onf);
        buttonWord.setEnabled(onf);
    }
    
    public void pressButton(javax.swing.JButton b) {
        String name = b.getActionCommand();
        guess += name;
        textInfo.setText("You guessed the letter " + name + "!\n");
        b.setEnabled(false);
        refresh(name);
    }
    
    public void refresh(String name) {
        textWord.setText(getShowWord(word, guess));
        if (word.contains(name)) {
            textInfo.setText(textInfo.getText() + "\nLucky! '" + name + "' was "
                    + "in the word!");
            coins += 1;
        }
        else {
            lives -= 1;
            if (lives >= 1){
                if (name.length() > 1) {
                    textInfo.setText("Sorry! That was not the correct word.");
                }
                textInfo.setText(textInfo.getText() + "\nToo bad. Try again.");
            }
            else {
                textInfo.setText("Your bonsai tree died. :(\nClick 'New Game' to"
                        + " restart.");
                textInfo.setText(textInfo.getText() + "\nThe word was: " + word + ".");
                allButtons(false);
                buttonFertilizer.setEnabled(false);
                buttonNewBonsai.setEnabled(false);
                coins = 0;
            }
        }
        drawBonsai();
        money();
        if (getShowWord(word, guess).equals(word)) {
            winner();
        }
    }
    
    public void money() {
        textCoins.setText("Coins: " + coins);
        if (coins >= 5) {
            buttonFertilizer.setEnabled(true);
        }
        else {
            buttonFertilizer.setEnabled(false);
            buttonNewBonsai.setEnabled(false);
        }
        if (coins >= 10) {
            buttonNewBonsai.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLetters = new javax.swing.JPanel();
        buttonA = new javax.swing.JButton();
        buttonC = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonE = new javax.swing.JButton();
        buttonD = new javax.swing.JButton();
        buttonF = new javax.swing.JButton();
        buttonG = new javax.swing.JButton();
        buttonH = new javax.swing.JButton();
        buttonI = new javax.swing.JButton();
        buttonJ = new javax.swing.JButton();
        buttonK = new javax.swing.JButton();
        buttonL = new javax.swing.JButton();
        buttonP = new javax.swing.JButton();
        buttonQ = new javax.swing.JButton();
        buttonR = new javax.swing.JButton();
        buttonS = new javax.swing.JButton();
        buttonT = new javax.swing.JButton();
        buttonO = new javax.swing.JButton();
        buttonM = new javax.swing.JButton();
        buttonN = new javax.swing.JButton();
        buttonU = new javax.swing.JButton();
        buttonV = new javax.swing.JButton();
        buttonW = new javax.swing.JButton();
        buttonX = new javax.swing.JButton();
        buttonY = new javax.swing.JButton();
        buttonZ = new javax.swing.JButton();
        buttonWord = new javax.swing.JButton();
        panelText = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textInfo = new javax.swing.JTextArea();
        textCoins = new javax.swing.JTextField();
        buttonFertilizer = new javax.swing.JButton();
        buttonNewBonsai = new javax.swing.JButton();
        textWord = new javax.swing.JTextField();
        buttonNewGame = new javax.swing.JButton();
        panelBonsai = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        panelTitle = new javax.swing.JPanel();
        labelBonsai = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonA.setText("A");
        buttonA.setActionCommand("a");
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });

        buttonC.setText("C");
        buttonC.setActionCommand("c");
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });

        buttonB.setText("B");
        buttonB.setActionCommand("b");
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });

        buttonE.setText("E");
        buttonE.setActionCommand("e");
        buttonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEActionPerformed(evt);
            }
        });

        buttonD.setText("D");
        buttonD.setActionCommand("d");
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });

        buttonF.setText("F");
        buttonF.setActionCommand("f");
        buttonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFActionPerformed(evt);
            }
        });

        buttonG.setText("G");
        buttonG.setActionCommand("g");
        buttonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGActionPerformed(evt);
            }
        });

        buttonH.setText("H");
        buttonH.setActionCommand("h");
        buttonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHActionPerformed(evt);
            }
        });

        buttonI.setText("I");
        buttonI.setActionCommand("i");
        buttonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIActionPerformed(evt);
            }
        });

        buttonJ.setText("J");
        buttonJ.setActionCommand("j");
        buttonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJActionPerformed(evt);
            }
        });

        buttonK.setText("K");
        buttonK.setActionCommand("k");
        buttonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKActionPerformed(evt);
            }
        });

        buttonL.setText("L");
        buttonL.setActionCommand("l");
        buttonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLActionPerformed(evt);
            }
        });

        buttonP.setText("P");
        buttonP.setActionCommand("p");
        buttonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPActionPerformed(evt);
            }
        });

        buttonQ.setText("Q");
        buttonQ.setActionCommand("q");
        buttonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQActionPerformed(evt);
            }
        });

        buttonR.setText("R");
        buttonR.setActionCommand("r");
        buttonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRActionPerformed(evt);
            }
        });

        buttonS.setText("S");
        buttonS.setActionCommand("s");
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSActionPerformed(evt);
            }
        });

        buttonT.setText("T");
        buttonT.setActionCommand("t");
        buttonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTActionPerformed(evt);
            }
        });

        buttonO.setText("O");
        buttonO.setActionCommand("o");
        buttonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOActionPerformed(evt);
            }
        });

        buttonM.setText("M");
        buttonM.setActionCommand("m");
        buttonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMActionPerformed(evt);
            }
        });

        buttonN.setText(" N");
        buttonN.setActionCommand("n");
        buttonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNActionPerformed(evt);
            }
        });

        buttonU.setText("U");
        buttonU.setActionCommand("u");
        buttonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUActionPerformed(evt);
            }
        });

        buttonV.setText("V");
        buttonV.setActionCommand("v");
        buttonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVActionPerformed(evt);
            }
        });

        buttonW.setText("W");
        buttonW.setActionCommand("w");
        buttonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWActionPerformed(evt);
            }
        });

        buttonX.setText("X");
        buttonX.setActionCommand("x");
        buttonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXActionPerformed(evt);
            }
        });

        buttonY.setText("Y");
        buttonY.setActionCommand("y");
        buttonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYActionPerformed(evt);
            }
        });

        buttonZ.setText("Z");
        buttonZ.setActionCommand("z");
        buttonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZActionPerformed(evt);
            }
        });

        buttonWord.setText("GUESS THE ENTIRE WORD!");
        buttonWord.setActionCommand("entireword");
        buttonWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLettersLayout = new javax.swing.GroupLayout(panelLetters);
        panelLetters.setLayout(panelLettersLayout);
        panelLettersLayout.setHorizontalGroup(
            panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLettersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLettersLayout.createSequentialGroup()
                        .addComponent(buttonU, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonV, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonW, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonX, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonY, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonZ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWord, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panelLettersLayout.createSequentialGroup()
                        .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonG, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonI, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonJ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLettersLayout.createSequentialGroup()
                        .addComponent(buttonK, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonO, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonQ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonS, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLettersLayout.setVerticalGroup(
            panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLettersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonG, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonI, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonJ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonK, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonO, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonQ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonS, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLettersLayout.createSequentialGroup()
                        .addComponent(buttonWord, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonU, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonV, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonW, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonX, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonY, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonZ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        textInfo.setColumns(20);
        textInfo.setFont(new java.awt.Font("Papyrus", 0, 16)); // NOI18N
        textInfo.setRows(5);
        jScrollPane1.setViewportView(textInfo);

        textCoins.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCoins.setText("Coins: 0");

        buttonFertilizer.setText("Fertilizer");
        buttonFertilizer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFertilizerActionPerformed(evt);
            }
        });

        buttonNewBonsai.setText("New Bonsai");
        buttonNewBonsai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewBonsaiActionPerformed(evt);
            }
        });

        textWord.setFont(new java.awt.Font("Lao MN", 0, 60)); // NOI18N
        textWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonNewGame.setText("NEW GAME");
        buttonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTextLayout = new javax.swing.GroupLayout(panelText);
        panelText.setLayout(panelTextLayout);
        panelTextLayout.setHorizontalGroup(
            panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTextLayout.createSequentialGroup()
                        .addComponent(buttonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textCoins, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonFertilizer, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNewBonsai, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(textWord))
                .addContainerGap())
        );
        panelTextLayout.setVerticalGroup(
            panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonFertilizer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonNewBonsai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textCoins, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textWord))
        );

        labelImage.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelBonsaiLayout = new javax.swing.GroupLayout(panelBonsai);
        panelBonsai.setLayout(panelBonsaiLayout);
        panelBonsaiLayout.setHorizontalGroup(
            panelBonsaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBonsaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBonsaiLayout.setVerticalGroup(
            panelBonsaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBonsaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelBonsai.setFont(new java.awt.Font("Papyrus", 0, 50)); // NOI18N
        labelBonsai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBonsai.setText("Bonsai");
        labelBonsai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTitleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTitleLayout.createSequentialGroup()
                        .addComponent(labelBonsai, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addGroup(panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTitleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelBonsai, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panelTitleLayout.createSequentialGroup()
                        .addGap(0, 80, Short.MAX_VALUE)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBonsai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLetters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBonsai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLetters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewGameActionPerformed
        String choice = UserInput.getString("You are about to start a new game.\n"
                + "You will lose all progress. Continue?\n(Y/N)");
        if (choice.equals("Y")) {
            startNewGame();
        }
    }//GEN-LAST:event_buttonNewGameActionPerformed

    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        pressButton(buttonA);
    }//GEN-LAST:event_buttonAActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBActionPerformed
        pressButton(buttonB);
    }//GEN-LAST:event_buttonBActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCActionPerformed
        pressButton(buttonC);
    }//GEN-LAST:event_buttonCActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDActionPerformed
        pressButton(buttonD);
    }//GEN-LAST:event_buttonDActionPerformed

    private void buttonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEActionPerformed
        pressButton(buttonE);
    }//GEN-LAST:event_buttonEActionPerformed

    private void buttonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFActionPerformed
        pressButton(buttonF);
    }//GEN-LAST:event_buttonFActionPerformed

    private void buttonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGActionPerformed
        pressButton(buttonG);
    }//GEN-LAST:event_buttonGActionPerformed

    private void buttonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHActionPerformed
        pressButton(buttonH);
    }//GEN-LAST:event_buttonHActionPerformed

    private void buttonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIActionPerformed
        pressButton(buttonI);
    }//GEN-LAST:event_buttonIActionPerformed

    private void buttonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJActionPerformed
        pressButton(buttonJ);
    }//GEN-LAST:event_buttonJActionPerformed

    private void buttonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKActionPerformed
        pressButton(buttonK);
    }//GEN-LAST:event_buttonKActionPerformed

    private void buttonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLActionPerformed
        pressButton(buttonL);
    }//GEN-LAST:event_buttonLActionPerformed

    private void buttonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMActionPerformed
        pressButton(buttonM);
    }//GEN-LAST:event_buttonMActionPerformed

    private void buttonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNActionPerformed
        pressButton(buttonN);
    }//GEN-LAST:event_buttonNActionPerformed

    private void buttonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOActionPerformed
        pressButton(buttonO);
    }//GEN-LAST:event_buttonOActionPerformed

    private void buttonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPActionPerformed
        pressButton(buttonP);
    }//GEN-LAST:event_buttonPActionPerformed

    private void buttonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQActionPerformed
        pressButton(buttonQ);
    }//GEN-LAST:event_buttonQActionPerformed

    private void buttonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRActionPerformed
        pressButton(buttonR);
    }//GEN-LAST:event_buttonRActionPerformed

    private void buttonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSActionPerformed
        pressButton(buttonS);
    }//GEN-LAST:event_buttonSActionPerformed

    private void buttonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTActionPerformed
        pressButton(buttonT);
    }//GEN-LAST:event_buttonTActionPerformed

    private void buttonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUActionPerformed
        pressButton(buttonU);
    }//GEN-LAST:event_buttonUActionPerformed

    private void buttonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVActionPerformed
        pressButton(buttonV);
    }//GEN-LAST:event_buttonVActionPerformed

    private void buttonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWActionPerformed
        pressButton(buttonW);
    }//GEN-LAST:event_buttonWActionPerformed

    private void buttonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXActionPerformed
        pressButton(buttonX);
    }//GEN-LAST:event_buttonXActionPerformed

    private void buttonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYActionPerformed
        pressButton(buttonY);
    }//GEN-LAST:event_buttonYActionPerformed

    private void buttonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZActionPerformed
        pressButton(buttonZ);
    }//GEN-LAST:event_buttonZActionPerformed

    private void buttonWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWordActionPerformed
        String gss = (UserInput.getString("Guess the entire word: ")).toLowerCase();
        if (gss.equals(word)) {
            winner();
        }
        else {
            refresh(gss);
        }
    }//GEN-LAST:event_buttonWordActionPerformed

    private void buttonFertilizerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFertilizerActionPerformed
        String choice = UserInput.getString("Spend 5 coins on a hint?\n(Y/N)");
        if (choice.equals("Y")) {
            int i = (int)(Math.random()*word.length());
            String hint = word.substring(i, i+1);
            while (guess.contains(hint)) {
                i = (int)(Math.random()*word.length());
                hint = word.substring(i, i+1);
            }
            hint = hint.toUpperCase();
            textInfo.setText("You bought Fertilizer '" + hint + "'!\nUse it now.");
            coins -= 5;
            money();
        }
    }//GEN-LAST:event_buttonFertilizerActionPerformed

    private void buttonNewBonsaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewBonsaiActionPerformed
        String choice = UserInput.getString("Spend 10 coins on a new bonsai?\n(Y/N)");
        if (choice.equals("Y")) {
            word = wm.getWord();
            guess = "";
            textWord.setText(getShowWord(word, guess));
            textInfo.setText("You've bought a new bonsai. Good luck!");
            coins -= 10;
            money();
            lives = 5;
            drawBonsai();
            allButtons(true);
        }
    }//GEN-LAST:event_buttonNewBonsaiActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BonsaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BonsaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BonsaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BonsaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BonsaiFrame().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonA;
    private javax.swing.JButton buttonB;
    private javax.swing.JButton buttonC;
    private javax.swing.JButton buttonD;
    private javax.swing.JButton buttonE;
    private javax.swing.JButton buttonF;
    private javax.swing.JButton buttonFertilizer;
    private javax.swing.JButton buttonG;
    private javax.swing.JButton buttonH;
    private javax.swing.JButton buttonI;
    private javax.swing.JButton buttonJ;
    private javax.swing.JButton buttonK;
    private javax.swing.JButton buttonL;
    private javax.swing.JButton buttonM;
    private javax.swing.JButton buttonN;
    private javax.swing.JButton buttonNewBonsai;
    private javax.swing.JButton buttonNewGame;
    private javax.swing.JButton buttonO;
    private javax.swing.JButton buttonP;
    private javax.swing.JButton buttonQ;
    private javax.swing.JButton buttonR;
    private javax.swing.JButton buttonS;
    private javax.swing.JButton buttonT;
    private javax.swing.JButton buttonU;
    private javax.swing.JButton buttonV;
    private javax.swing.JButton buttonW;
    private javax.swing.JButton buttonWord;
    private javax.swing.JButton buttonX;
    private javax.swing.JButton buttonY;
    private javax.swing.JButton buttonZ;
    private java.awt.Canvas canvas1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBonsai;
    private javax.swing.JLabel labelImage;
    private javax.swing.JPanel panelBonsai;
    private javax.swing.JPanel panelLetters;
    private javax.swing.JPanel panelText;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JTextField textCoins;
    private javax.swing.JTextArea textInfo;
    private javax.swing.JTextField textWord;
    // End of variables declaration//GEN-END:variables
}
