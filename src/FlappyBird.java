import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener{
    int boardWidth = 360;
    int boardHeight = 640;

    //Images
    Image backgroundImage;
    Image birdImage;
    Image topPipeImage;
    Image bottomPipeImage;

    //Bird
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight =24;

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    class Bird{
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image  img;

        Bird(Image img){
            this.img = img;
        }

    }

    //Game Logic
    Bird bird;

    Timer gameLoop;


    FlappyBird(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);

        //load images
        backgroundImage = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImage = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImage = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //Bird
        bird = new Bird(birdImage);

        //Game Timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

    }
public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
}
public void draw(Graphics g){
        //Background
    g.drawImage(backgroundImage, 0,0, boardWidth, boardHeight, null);


    //Bird
    g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
}
}
