

import java.awt.Image;

import java.util.Random;



public class Enemy {

	

	Image img; //�̹��� ��������

	int x, y; //�̹��� �߽� ��ǥ

	int w, h; //�̹��� ������, ���ݳ���

	

	int dy; //������ ��ȭ��

	

	int width, height; //ȭ��(panel)�� ������

	//���� ��ü�� �׾����� ����!

	boolean isDead = false;

	

	public Enemy(Image imgEnemy, int width, int height) {

		this.width = width;

		this.height = height;

		

		//������� �� �ʱ�ȭ..

		img = imgEnemy.getScaledInstance(64, 64, Image.SCALE_SMOOTH);

		w = 32; //�̹��� ���ݳ���

		h = 32;

				

		Random rnd = new Random();

		x = rnd.nextInt(width - w * 2) + w; //w ~ width - w

		y = -h;

		

		dy =+ rnd.nextInt(15) + 1;//�������� �ӵ� �����ϰ�

	}

	

	void move() { //Enemy�� �����̴� ��� �޼ҵ�

		y += dy;

		//���� ȭ�� ������ ���������� ��ü ���ֱ�

		if( y > height + h ) { //ArrayList���� ����

			isDead = true; //���� ǥ��! 

		}

	}

}
