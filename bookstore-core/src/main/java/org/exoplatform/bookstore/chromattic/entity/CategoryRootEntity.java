/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.bookstore.chromattic.entity;

import java.util.Map;

import org.chromattic.api.annotations.Create;
import org.chromattic.api.annotations.FormattedBy;
import org.chromattic.api.annotations.Id;
import org.chromattic.api.annotations.MappedBy;
import org.chromattic.api.annotations.Name;
import org.chromattic.api.annotations.OneToMany;
import org.chromattic.api.annotations.OneToOne;
import org.chromattic.api.annotations.Path;
import org.chromattic.api.annotations.PrimaryType;
import org.chromattic.ext.format.BaseEncodingObjectFormatter;
import org.exoplatform.bookstore.common.BookstoreConstants;

/**
 * Created by The eXo Platform SAS
 * Author : quangpld
 *          quangpld@exoplatform.com
 * Nov 14, 2011  
 */
@PrimaryType(name = BookstoreConstants.NODETYPE_CATEGORIES)
@FormattedBy(BaseEncodingObjectFormatter.class)
public abstract class CategoryRootEntity {

  /**
   * Returns the node id.
   *
   * @return the node id
   */
  @Id
  public abstract String getId();

  /**
   * Returns the node path.
   *
   * @return the node path
   */
  @Path
  public abstract String getPath();

  /**
   * Returns the node name.
   *
   * @return the node name
   */
  @Name
  public abstract String getName();
  
  /**
   * Returns the bookstore.
   *
   * @return the bookstore
   */
  @OneToOne
  @MappedBy(BookstoreConstants.NODENAME_CATEGORIES)
  public abstract BookstoreEntity getBookstore();
  public abstract void setBookstore(BookstoreEntity bookstoreEntity);
  
  /**
   * Create the category
   * 
   * @return the category 
   */
  @Create
  public abstract CategoryEntity createCategory();
  
  /**
   * Returns the category list.
   *
   * @return the category list
   */
  @OneToMany
  public abstract Map<String, CategoryEntity> getCategories();
}
