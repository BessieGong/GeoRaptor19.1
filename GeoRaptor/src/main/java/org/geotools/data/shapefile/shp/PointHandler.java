/*
 *    GeoTools - OpenSource mapping toolkit
 *    http://geotools.org
 *    (C) 2002-2006, Geotools Project Managment Committee (PMC)
 *    (C) 2002, Centre for Computational Geography
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.data.shapefile.shp;

import java.nio.ByteBuffer;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;


/**
 * Wrapper for a Shapefile point.
 *
 * @author aaime
 * @author Ian Schneider
 * @source $URL: http://svn.geotools.org/tags/2.4.5/modules/plugin/shapefile/src/main/java/org/geotools/data/shapefile/shp/PointHandler.java $
 * 
 */
public class PointHandler implements ShapeHandler {

  final ShapeType shapeType;
  GeometryFactory geometryFactory = new GeometryFactory();
  
  public PointHandler(ShapeType type) throws ShapefileException {
    if ((type != ShapeType.POINT) && (type != ShapeType.POINTM) && (type != ShapeType.POINTZ)) { // 2d, 2d+m, 3d+m
      throw new ShapefileException(
      "PointHandler constructor: expected a type of 1, 11 or 21");
    }
    
    shapeType = type;
  }
  
  public PointHandler() {
    shapeType = ShapeType.POINT; //2d
  }
  
  /**
   * Returns the shapefile shape type value for a point
   * @return int Shapefile.POINT
   */
  public ShapeType getShapeType() {
    return shapeType;
  }
  
  
  public int getLength(Object geometry) {
    int length;
    if (shapeType == ShapeType.POINT) {
      length = 20;
    } else if (shapeType == ShapeType.POINTM) {
      length = 28;
    } else if (shapeType == ShapeType.POINTZ) {
      length = 36;
    } else {
      throw new IllegalStateException("Expected ShapeType of Point, got" + shapeType);
    }
    return length;
  }
  
  public Object read(ByteBuffer buffer, ShapeType type) {
    if (type == ShapeType.NULL) {
      return createNull();
    }
    
    double x = buffer.getDouble();
    double y = buffer.getDouble();
    double z = Double.NaN;
    
    if (shapeType == ShapeType.POINTM) {
      buffer.getDouble();
    }
    
    if (shapeType == ShapeType.POINTZ) {
      z = buffer.getDouble();
    }
    
    return geometryFactory.createPoint(new Coordinate(x, y, z));
  }
  
  private Object createNull() {
    return geometryFactory.createPoint(new Coordinate(Double.NaN,Double.NaN,Double.NaN));
  }
  
  public void write(ByteBuffer buffer, Object geometry) {
    Coordinate c = ((Point) geometry).getCoordinate();
    
    buffer.putDouble(c.x);
    buffer.putDouble(c.y);
    
    if (shapeType == ShapeType.POINTZ) {
      if (Double.isNaN(c.z)) { // nan means not defined
        buffer.putDouble(0.0);
      } else {
        buffer.putDouble(c.z);
      }
    }
    
    if ((shapeType == ShapeType.POINTZ) || (shapeType == ShapeType.POINTM)) {
      buffer.putDouble(-10E40); //M
    }
  }
  
}
