package Project;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Square extends JPanel {

    int number;
    private String name;
    String description;
    JLabel nameLabel;
    static int totalSquares = 0;
    private int price;
    private int rentPrice;

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    public Square(int xCoord, int yCoord, int width, int height, String labelString, int rotationDegrees) {
        number = totalSquares;
        totalSquares++;
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, width, height);
        name = labelString;
        this.setLayout(null);

        if(rotationDegrees == 0) {
            nameLabel = new JLabel(labelString);
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setBounds(0,20,this.getWidth(),20);
            this.add(nameLabel);
        } else {
            // rotating a Jlabel: https://www.daniweb.com/programming/software-development/threads/390060/rotate-jlabel-or-image-in-label

            nameLabel = new JLabel(labelString) {
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth()/2.0;
                    double y = getHeight()/2.0;
                    aT.rotate(Math.toRadians(rotationDegrees), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };
            if(rotationDegrees == 90) {
                nameLabel.setBounds(20, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == -90) {
                nameLabel.setBounds(-10, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 180) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            if(rotationDegrees == 135 || rotationDegrees == -135 || rotationDegrees == -45 || rotationDegrees == 45) {
                nameLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

            this.add(nameLabel);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.number >0&&this.number<10&&this.number!=2&&this.number!=7) {
            g.drawRect(0, this.getHeight()-20, this.getWidth(), 20);
            g.setColor(Color.BLUE);
            g.fillRect(0, this.getHeight()-20, this.getWidth(), 20);
        }
        if(this.number >10&&this.number<20&&this.number!=17) {
            g.drawRect(0, 0, 20, this.getHeight());
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, 20, this.getHeight());
        }
        if(this.number >20&&this.number<=30&&this.number!=22) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.RED);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if(this.number >30&&this.number<=39&&this.number!=33&&this.number!=36) {
            g.drawRect(this.getWidth()-20, 0, 20, this.getHeight());
            g.setColor(Color.GREEN);
            g.fillRect(this.getWidth()-20, 0, 20, this.getHeight());
        }
        if (number==2 || number ==17 || number ==33) {
            setBackground(Color.BLUE);
        }
        if (number==7 || number ==22 || number ==36) setBackground(Color.RED);

    }




    private boolean isRentPaid = false;
    public boolean isRentPaid() {
        return isRentPaid;
    }
    public void setRentPaid(boolean pay) {
        isRentPaid = pay;
    }

}

