package Project;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

    public class Board extends JPanel {

        private ArrayList<Square> allSquares = new ArrayList<Square>();
        private ArrayList<Square> unbuyableSquares = new ArrayList<Square>(); // squares like "Go", "Chances" etc...

        public ArrayList<Square> getUnbuyableSquares(){
            return unbuyableSquares;
        }

        public ArrayList<Square> getAllSquares(){
            return allSquares;
        }

        public Square getSquareAtIndex(int location) {
            return allSquares.get(location);
        }

        public Board(int xCoord, int yCoord, int width, int height) {
            setBorder(new LineBorder(new Color(0, 0, 0)));
            setBounds(xCoord, yCoord, 1332, 902);
            this.setLayout(null);
            initializeSquares();
        }

        private void initializeSquares() {
            // TODO Auto-generated method stub
            String[] squareNames = {
                    //Hàng 1
                    "Bắt đầu", "Phố Cổ", "Khí vận","Chợ Đông Xuân","Thuê Lương Bổng", "Ga Hà Nội", "Bưu Điện Hà Nội", "Cơ Hội", "Nhà Hát Lớn","Tháp Rùa","Vào Tù",
                    //Hàng 2
                    "Quảng Trường Ba Đình", "Nhà Máy Điện","Hoàng Thành", "Văn Miếu","Ga Vinh","Vịnh Hạ Long","Khí Vận","Sơn Đoòng","Tràng An","Bãi Đỗ Xe",
                    //Hàng 3
                    "Cầu Rồng Đà Nẵng","Cơ Hội","Cung Đình Huế","Hội An","Ga Đà Nẵng","Dinh Độc Lập","Nhà Thờ Đức Bà","Nhà Máy Nước","Bến Nhà Rồng","Vào Tù",
                    //Hàng 4
                    "Chợ Bến Thành","Đường Nguyễn Huệ","Khí vận","Land Mark 81","Ga Sài Gòn","Cơ Hội","Trường Sa","Thuế Lợi Tức","Phú Quốc",


            };


            // squares on the top
            Square square00 = new Square(6,6,120,80,squareNames[0],135);
            this.add(square00);
            allSquares.add(square00);
            unbuyableSquares.add(square00);

            Square square01 = new Square(126,6,120,80,squareNames[1],180);
            this.add(square01);
            allSquares.add(square01);

            Square square02 = new Square(246,6,120,80,squareNames[2],180);
            this.add(square02);
            allSquares.add(square02);
            unbuyableSquares.add(square02);

            Square square03 = new Square(366,6,120,80,squareNames[3],180);
            this.add(square03);
            allSquares.add(square03);

            Square square04 = new Square(486,6,120,80,squareNames[4],180);
            this.add(square04);
            allSquares.add(square04);

            Square square05 = new Square(606,6,120,80,squareNames[5],180);
            this.add(square05);
            allSquares.add(square05);
            unbuyableSquares.add(square05);

            Square square06 = new Square(726,6,120,80,squareNames[6],180);
            this.add(square06);
            allSquares.add(square06);

            Square square07 = new Square(846,6,120,80,squareNames[7],180);
            this.add(square07);
            allSquares.add(square07);

            Square square08 = new Square(966,6,120,80,squareNames[8],180);
            this.add(square08);
            allSquares.add(square08);

            Square square09 = new Square(1086,6,120,80,squareNames[9],180);
            this.add(square09);
            allSquares.add(square09);

            Square square10= new Square(1206,6,120,80,squareNames[10],-135);
            this.add(square10);
            allSquares.add(square10);


            // squares on the right
            Square square11 = new Square(1206,86,120,80,squareNames[11],-90);
            this.add(square11);
            allSquares.add(square11);

            Square square12 = new Square(1206,166,120,80,squareNames[12],-90);
            this.add(square12);
            allSquares.add(square12);
            unbuyableSquares.add(square12);

            Square square13 = new Square(1206,246,120,80,squareNames[13],-90);
            this.add(square13);
            allSquares.add(square13);

            Square square14 = new Square(1206,326,120,80,squareNames[14],-90);
            this.add(square14);
            allSquares.add(square14);

            Square square15 = new Square(1206,406,120,80,squareNames[15],-90);
            this.add(square15);
            allSquares.add(square15);

            Square square16 = new Square(1206,486,120,80,squareNames[16],-90);
            this.add(square16);
            allSquares.add(square16);

            Square square17 = new Square(1206,566,120,80,squareNames[17],-90);
            this.add(square17);
            allSquares.add(square17);
            unbuyableSquares.add(square17);

            Square square18 = new Square(1206,646,120,80,squareNames[18],-90);
            this.add(square18);
            allSquares.add(square18);

            Square square19 = new Square(1206,726,120,80,squareNames[19],-90);
            this.add(square19);
            allSquares.add(square19);

            Square square20 = new Square(1206,806,120,80,squareNames[20],-45);
            this.add(square20);
            allSquares.add(square20);

            // squares on the bottom
            Square square21 = new Square(1086,806,120,80,squareNames[21],0);
            this.add(square21);
            allSquares.add(square21);

            Square square22 = new Square(966,806,120,80,squareNames[22],0);
            this.add(square22);
            allSquares.add(square22);
            unbuyableSquares.add(square22);

            Square square23 = new Square(846,806,120,80,squareNames[23],0);
            this.add(square23);
            allSquares.add(square23);

            Square square24 = new Square(726,806,120,80,squareNames[24],0);
            this.add(square24);
            allSquares.add(square24);

            Square square25 = new Square(606,806,120,80,squareNames[24],0);
            this.add(square25);
            allSquares.add(square25);

            Square square26 = new Square(486,806,120,80,squareNames[26],0);
            this.add(square26);
            allSquares.add(square26);


            Square square27 = new Square(366,806,120,80,squareNames[27],0);
            this.add(square27);
            allSquares.add(square27);
            unbuyableSquares.add(square27);

            Square square28 = new Square(246,806,120,80,squareNames[28],0);
            this.add(square28);
            allSquares.add(square28);

            Square square29 = new Square(126,806,120,80,squareNames[29],0);
            this.add(square29);
            allSquares.add(square29);

            Square square30 = new Square(6,806,120,80,squareNames[30],45);
            this.add(square30);
            allSquares.add(square30);

            // squares on the left
            Square square31 = new Square(6,726,120,80,squareNames[31],90);
            this.add(square31);
            allSquares.add(square31);

            Square square32 = new Square(6,646,120,80,squareNames[32],90);
            this.add(square32);
            allSquares.add(square32);

            Square square33 = new Square(6,566,120,80,squareNames[33],90);
            this.add(square33);
            allSquares.add(square33);
            unbuyableSquares.add(square33);

            Square square34 = new Square(6,486,120,80,squareNames[34],90);
            this.add(square34);
            allSquares.add(square34);

            Square square35 = new Square(6,406,120,80,squareNames[35],90);
            this.add(square35);
            allSquares.add(square35);

            Square square36 = new Square(6,326,120,80,squareNames[36],90);
            this.add(square36);
            allSquares.add(square36);

            Square square37 = new Square(6,246,120,80,squareNames[37],90);
            this.add(square37);
            allSquares.add(square37);

            Square square38 = new Square(6,166,120,80,squareNames[38],90);
            this.add(square38);
            allSquares.add(square38);

            Square square39 = new Square(6,86,120,80,squareNames[39],90);
            this.add(square39);
            allSquares.add(square39);


// setting prices
            square01.setPrice(60);
            square03.setPrice(60);
            square04.setPrice(80);
            square05.setPrice(100);
            square06.setPrice(100);
            square08.setPrice(120);
            square09.setPrice(120);

            square11.setPrice(140);
            square12.setPrice(140);
            square13.setPrice(160);
            square14.setPrice(160);
            square15.setPrice(180);
            square16.setPrice(180);
            square18.setPrice(200);
            square19.setPrice(200);

            square21.setPrice(220);
            square23.setPrice(220);
            square24.setPrice(240);
            square25.setPrice(240);
            square26.setPrice(260);
            square27.setPrice(260);
            square28.setPrice(280);
            square29.setPrice(280);

            square31.setPrice(300);
            square32.setPrice(300);
            square34.setPrice(320);
            square35.setPrice(320);
            square37.setPrice(360);
            square38.setPrice(400);
            square39.setPrice(400);

            //square20.setPrice(320);


            // setting rent prcies
            square01.setRentPrice(6);
            square03.setRentPrice(6);
            square04.setRentPrice(8);
            square05.setRentPrice(10);
            square06.setRentPrice(10);
            square08.setRentPrice(12);
            square09.setRentPrice(12);

            square11.setRentPrice(14);
            square12.setRentPrice(14);
            square13.setRentPrice(16);
            square14.setRentPrice(16);
            square15.setRentPrice(18);
            square16.setRentPrice(18);
            square18.setRentPrice(20);
            square19.setRentPrice(20);

            square21.setRentPrice(22);
            square23.setRentPrice(22);
            square24.setRentPrice(24);
            square25.setRentPrice(24);
            square26.setRentPrice(26);
            square27.setRentPrice(26);
            square28.setRentPrice(28);
            square29.setRentPrice(28);

            square31.setRentPrice(30);
            square32.setRentPrice(30);
            square34.setRentPrice(32);
            square35.setRentPrice(32);
            square37.setRentPrice(36);
            square38.setRentPrice(40);
            square39.setRentPrice(40);
            //  square20.setRentPrice(28);












            JLabel lblMonopoly = new JLabel("MONOPOLY"){
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth()/10.0;
                    double y = getHeight()/10.0;
                    aT.rotate(Math.toRadians(-35), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };
            lblMonopoly.setForeground(Color.RED);
            lblMonopoly.setBackground(Color.BLACK);
            lblMonopoly.setOpaque(true);
            lblMonopoly.setHorizontalAlignment(SwingConstants.CENTER);
            lblMonopoly.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
            lblMonopoly.setBounds(496, 497, 413, 105);
            this.add(lblMonopoly);

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }




    }





