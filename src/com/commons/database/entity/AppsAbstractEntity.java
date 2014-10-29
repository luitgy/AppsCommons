package com.commons.database.entity;

import java.util.ArrayList;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public interface AppsAbstractEntity {

	public String getTable();

	public ArrayList<String> getColumns();

	public ArrayList<Object> getValues();

}
