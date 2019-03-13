package com.quad.entity;

import com.quad.core.GameContainer;
import com.quad.core.Renderer;
import com.quad.core.fx.ShadowType;

public class Rect {
	
	private float x;
	private float y;
	private float dx;
	private float dy;
	private float speed;
	private int width;
	private int height;
	private boolean right;
	private boolean up;
	
	public Rect(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		dx = 1;
		speed = 1;
		right = true;
		this.width = width;
		this.height = height;
	}
	
	public void update(GameContainer gc) {
		x += dx;
		y += dy;
		
		move(gc);
	}
	
	public void render(Renderer r) {
		r.drawFillRect((int)x, (int)y, width, height, 0xf74e16, ShadowType.HALF);
	}
	
	private void move(GameContainer gc) {
		System.out.println(right);
		//right
		if((x + width) >= gc.getWidth() - 35 && right) {
			dx = 0;
			up = false;
			if(width > 10) {
				width--;
				x++;
			}
			
			if(width <= 10 && height <= 50) {
				height++;
			}
			
			if(width == 10 && height == 50) dy = speed;
			
		}
		
		//left
		if((x) <= 0 + 35 && !right) {
			dx = 0;
			up = true;
			if(width > 10) {
				width--;
			}
			
			if(width <= 10 && height <= 50) {
				height++;
				y--;
			}
			
			if(width == 10 && height == 50) dy = -speed;
		}
		
		//down
		if((y + height) >= gc.getHeight()-35 && !up) {
			right = false;
			dy = 0;
			if(height > 10) {
				height--;
				y++;
			}
			
			if(height <= 10 && width <= 50) {
				width++;
				x--;
			}
			
			if(height == 10 && width == 50) dx = -speed;
		}
		
		//up
		if(y <= 35 && up) {
			dy = 0;
			right = true;
			if(height > 10) {
				height--;
			}
			
			if(height <= 10 && width <= 50) {
				width++;
			}
			
			if(height == 10 && width == 50) {
				dx = speed;
			}
			
		}
		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getDx() {
		return dx;
	}

	public float getDy() {
		return dy;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	
}
