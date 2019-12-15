package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Player extends JPanel {

    private int playerNumber;
    JLabel lblPlayerNumber;
    static int totalPlayers = 0; // we might need this number later on
    static HashMap<Integer, Integer> ledger= new HashMap<>();

    private int currentSquareNumber = 0; // where player is currently located on (0 - 19). initially zero
    private ArrayList<Integer> titleDeeds = new ArrayList<Integer>(); // squares that the player has
    private int wallet = 3200; // initial money

    public ArrayList<Integer> getTitleDeeds() {
        return titleDeeds;
    }

    public int getWallet() {
        return wallet;
    }

    public void withdrawFromWallet(int withdrawAmount) {
        if(withdrawAmount > wallet) {
            setVisible(false);
            System.out.println("Player "+ playerNumber + " went bankrupt!");
        } else {
            wallet -= withdrawAmount;
        }
    }

    public void depositToWallet(int depositAmount) {
        wallet += depositAmount;
        System.out.println("Payday for player "+getPlayerNumber()+". You earned $200!");
    }

    public int getCurrentSquareNumber() {
        return currentSquareNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public boolean hasTitleDeed(int squareNumber) {
        return titleDeeds.contains(squareNumber) ? true : false;
    }

    public void buyTitleDeed(int squareNumber) {
        if(ledger.containsKey(squareNumber)) {
            System.out.println("It's already bought by someone. You cannot by here.");
        } else {
            titleDeeds.add(this.getCurrentSquareNumber());
            ledger.put(squareNumber, this.getPlayerNumber()); // everytime a player buys a title deed, it is written in ledger, for example square 1 belongs to player 2

        }
    }

    public Player(int xCoord, int yCoord, int width, int height) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, 20, 20);
        this.setLayout(null);
    }

    public Player(int playerNumber, Color color) {
        // TODO Auto-generated constructor stub
        this.playerNumber = playerNumber;
        this.setBackground(color);
        lblPlayerNumber = new JLabel(""+playerNumber);
        lblPlayerNumber.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        lblPlayerNumber.setForeground(Color.WHITE);
        this.add(lblPlayerNumber);
        this.setBounds(playerNumber*30, 33, 20, 28); // need to fix here for adjustable player numbers
        totalPlayers++;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    int[] xLocationsOfPlayer1 = {
            31, 151, 271, 391, 511, 631, 751, 871, 991, 1111,
            1231, 1231, 1231, 1231, 1231, 1231, 1231, 1231, 1231, 1231,
            1231, 1111, 991, 871, 751, 631, 511, 391, 271, 151,
            31, 31, 31, 31, 31, 31, 31, 31, 31, 31};

    int[] yLocationsOfPlayer1 = {
            33, 33, 33, 33, 33, 33, 33, 33, 33, 33,
            33, 113, 193, 283, 363, 443, 523, 603, 683, 763,
            843, 843, 843, 843, 843, 843, 843, 843, 843, 843,
            843, 763, 683, 603, 523, 443, 363, 283, 193, 113};

    int[] xLocationsOfPlayer2 = {
            33, 153, 273, 393, 513, 633, 753, 873, 993, 1113,
            1233, 1233, 1233, 1233, 1233, 1233, 1233, 1233, 1233, 1233,
            1233, 1113, 993, 873, 753, 633, 513, 393, 273, 153,
            33, 33, 33, 33, 33, 33, 33, 33, 33, 33};

    int[] yLocationsOfPlayer2 = {
            33, 33, 33, 33, 33, 33, 33, 33, 33, 33,
            33, 113, 193, 283, 363, 443, 523, 603, 683, 763,
            843, 843, 843, 843, 843, 843, 843, 843, 843, 843,
            843, 763, 683, 603, 523, 443, 363, 283, 193, 113};


    public void move(int dicesTotal) {
        if(currentSquareNumber + dicesTotal > 39) {
            depositToWallet(500);
        }
        int targetSquare = (currentSquareNumber + dicesTotal) % 40;
        currentSquareNumber = targetSquare;

        if(MonopolyMain.nowPlaying == 0) {
            this.setLocation(xLocationsOfPlayer1[targetSquare], yLocationsOfPlayer1[targetSquare]);
        } else {
            this.setLocation(xLocationsOfPlayer2[targetSquare], yLocationsOfPlayer2[targetSquare]);
        }

        if(ledger.containsKey(this.getCurrentSquareNumber())) {
            MonopolyMain.infoConsole.setText("This property belongs to player "+ledger.get(this.getCurrentSquareNumber()));
        }
        //ledger.put(this.getCurrentSquareNumber(), this.getPlayerNumber());
    }



    // by comparing player's coordinates according to the board, we will get it's
    // current square number
    // currently unused, found a better way
    public int getCurrentSquareNumberByCoordinates() {

        int x = this.getX();
        int y = this.getY();

        if(x < 120) {
            if(y < 80) {
                return 0;
            } else if(y > 80 && y < 160) {
                return 39;
            } else if(y > 160 && y < 240) {
                return 38;
            } else if(y > 240 && y < 320) {
                return 37;
            } else if(y > 400 && y < 480) {
                return 36;
            } else if(y > 480 && y < 560) {
                return 35;
            }else if(y > 560 && y < 640) {
                return 34;
            } else if(y > 640 && y < 720) {
                return 33;
            } else if(y > 800 && y < 880) {
                return 32;
            } else {
                return 31;
            }
        } else if(x > 100 && x < 200) {
            if(y < 100) {
                return 1;
            } else {
                return 14;
            }
        } else if(x > 200 && x < 300) {
            if(y < 100) {
                return 2;
            } else {
                return 13;
            }
        } else if(x > 300 && x < 400) {
            if(y < 100) {
                return 3;
            } else {
                return 12;
            }
        }else if(x > 400 && x < 500) {
            if(y < 100) {
                return 4;
            } else {
                return 11;
            }
        } else {
            if(y < 100) {
                return 5;
            } else if(y > 100 && y < 200) {
                return 6;
            } else if(y > 200 && y < 300) {
                return 7;
            } else if(y > 300 && y < 400) {
                return 8;
            } else if(y > 300 && y < 500) {
                return 9;
            } else {
                return 10;
            }
        }
    }

}