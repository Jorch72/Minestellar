/**
 * Copyright (c) 05/apr/2015 Davide Cossu & Matthew Albrecht.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses>.
 */

package com.minestellar.core.gui;

import java.util.TimerTask;

import com.minestellar.core.gui.widget.GuiDraw;
import com.minestellar.core.gui.widget.planets.GuiPlanet;

/**
 * Timer task for the planets.
 */

public class PlanetTimer extends TimerTask{

	private String planetName;
	private double x = 0., y = 0., incr = 2;
	private boolean doTop = false, firstTime = true;

	private Planet planet;
	private GuiPlanet currentPlanet;

	public PlanetTimer(String planetName){
		this.planetName = planetName;
	}

	@Override
	public void run(){

		switch(this.planetName){
		case "earth":
			planet = Planet.EARTH;
			currentPlanet = ComputerGui.earth;
			break;
		case "moon":
			planet = Planet.MOON;
			currentPlanet = ComputerGui.moon;
			break;
		case "venus":
			planet = Planet.VENUS;
			currentPlanet = ComputerGui.venus;
			break;
		default:
			break;
		}

		if(firstTime){
			firstTime = false;
			x = -planet.getA();
		}

		if(x == 0.){
			if(!doTop){
				x += incr;
			}else{
				x -= incr;
			}
		}

		if(planet.equals(Planet.MOON)){
			y = Math.sqrt(Math.abs((planet.getB()*planet.getB())*(1-((ComputerGui.earth.x * ComputerGui.earth.x)/(planet.getA()*planet.getA())))));
		}else
			y = Math.sqrt(Math.abs((planet.getB()*planet.getB())*(1-((x*x)/(planet.getA()*planet.getA())))));

		if((x == planet.getA() && !doTop) || (x == -planet.getA() && doTop)){
			if(!doTop)
				doTop = true;
			else
				doTop = false;
		}

		if(doTop){
			y = -y;
			x -= incr;
		}else{
			x += incr;
		}

		switch(planet){
		case EARTH:
			currentPlanet.setCoords(GuiDraw.displaySize().width/2+4+(int)x, GuiDraw.displaySize().height/2+4+(int)y);
			System.out.println("EarthX: " + x + " EarthY: " + y + " DoTop: " + doTop + " EarthX: " + ComputerGui.earth.x);
			break;
		case MOON:
			//currentPlanet.setCoords(ComputerGui.earth.x+4+(int)x, ComputerGui.earth.y+4+(int)y);
			currentPlanet.setCoords(GuiDraw.displaySize().width/2+4+(int)x, GuiDraw.displaySize().height/2+4+(int)y);
			System.out.println("MoonX: " + x + " MoonY: " + y + " DoTop: " + doTop + " EarthX: " + ComputerGui.earth.x);
			break;
		case VENUS:
			currentPlanet.setCoords(GuiDraw.displaySize().width/2+4+(int)x, GuiDraw.displaySize().height/2+4+(int)y);
			break;
		default:
			break;
		}

		//System.out.println("X: " + x + " Y: " + y + " DoTop: " + doTop + " Planet: " + planet);
	}

}