/*
 * Copyright 2014-2015 Pawel Pastuszak
 *
 * This file is part of VisEditor.
 *
 * VisEditor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VisEditor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VisEditor.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.kotcrab.vis.editor.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglCanvas;
import com.kotcrab.vis.editor.App;
import com.kotcrab.vis.editor.Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditorFrame extends JFrame {
	private Editor editor;

	public EditorFrame () {
		setTitle("VisEditor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing (WindowEvent e) {
				editor.requestExit();
			}
		});

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.backgroundFPS = -1;

		editor = new Editor(this);

		LwjglCanvas editorCanvas = new LwjglCanvas(editor, config);
		Canvas canvas = editorCanvas.getCanvas();
		canvas.setSize(1280, 720);

		getContentPane().add(canvas, BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
	}

	public static void main (String[] args) {
		App.init();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run () {
				new EditorFrame().setVisible(true);
			}
		});
	}

	@Override
	public void dispose () {
		super.dispose();
		Gdx.app.exit();
	}
}
