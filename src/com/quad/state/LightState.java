package com.quad.state;

import java.util.ArrayList;

import com.quad.core.GameContainer;
import com.quad.core.Renderer;
import com.quad.core.Settings;
import com.quad.core.components.State;
import com.quad.core.fx.Light;
import com.quad.core.fx.ShadowType;
import com.quad.entity.Rect;

public class LightState extends State{
	
	//objects
	private ArrayList<Rect> objects;

	@Override
	public void init(GameContainer gc) {
		// TODO Auto-generated method stub
		System.out.println("Load State: LightState");
		Settings.setLight(gc, true);
		
		//load objects
		objects = new ArrayList<Rect>();
		Rect r;
		
		r = new Rect(10, 10, 50, 10);
		objects.add(r);
		
		r = new Rect(10, 100, 50, 10);
		objects.add(r);
		
	}

	@Override
	public void update(GameContainer gc, float dt) {
		// TODO Auto-generated method stub
		
		for(Rect r: objects) {
			r.update(gc);
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
		//render background
		r.drawFillRect(0, 0, gc.getWidth(), gc.getHeight(), 0xffffff);
		
		for(Rect re: objects) {
			re.render(r);
		}
		
		//render mouse
		r.drawFillRect(gc.getInput().getMouseX()-5, gc.getInput().getMouseY()-5, 10, 10, 0xdb5e15, ShadowType.HALF);
		
		//draw light
		r.drawLight(new Light(0xd6c955, 100), gc.getWidth()/2, gc.getHeight()/2);
	}

	@Override
	public void dipose() {
		// TODO Auto-generated method stub
		
	}

}
