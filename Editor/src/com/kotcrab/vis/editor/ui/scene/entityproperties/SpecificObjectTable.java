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

package com.kotcrab.vis.editor.ui.scene.entityproperties;

import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.editor.scene.EditorEntity;
import com.kotcrab.vis.ui.VisTable;

abstract class SpecificObjectTable extends VisTable {
	public SpecificObjectTable (boolean useVisDefaults) {
		super(useVisDefaults);
	}

	public abstract boolean isSupported (EditorEntity entity);

	public abstract void updateUIValues (Array<EditorEntity> entities);

	public abstract void setValuesToEntities (Array<EditorEntity> entities);
}
