package org.exolab.castor.xml;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.exolab.castor.xml.parsing.primitive.objects.PrimitiveObjectFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the functionality of PrimitiveObject.
 * 
 * @author <a href="mailto:philipp DOT erlacher AT gmail DOT com">Philipp Erlacher</a>
 * 
 */
public class PrimitiveObjectTest {

  @Test
  public void testPrimitiveBigDecimal() {
    BigDecimal decimal =
        (BigDecimal) PrimitiveObjectFactory.getInstance().getObject(BigDecimal.class, "-1.23E-12");

    Assert.assertEquals(decimal.unscaledValue(), new BigInteger("-123"));
    Assert.assertEquals(decimal.scale(), 14);

  }

  @Test
  public void testPrimitiveBigDecimalNull() {
    BigDecimal decimal =
        (BigDecimal) PrimitiveObjectFactory.getInstance().getObject(BigDecimal.class, null);
    Assert.assertEquals(decimal.unscaledValue(), BigInteger.ZERO);
    Assert.assertEquals(decimal.scale(), 0);
  }

  @Test
  public void testPrimitiveBigDecimalEmptyString() {
    BigDecimal decimal =
        (BigDecimal) PrimitiveObjectFactory.getInstance().getObject(BigDecimal.class, "");
    Assert.assertEquals(decimal.unscaledValue(), BigInteger.ZERO);
    Assert.assertEquals(decimal.scale(), 0);
  }

  @Test
  public void testPrimitiveBigInteger() {
    BigInteger bigInt =
        (BigInteger) PrimitiveObjectFactory.getInstance().getObject(BigInteger.class, "-123");
    Assert.assertEquals(bigInt, new BigInteger("-123"));
  }

  @Test
  public void testPrimitiveBigIntegerNull() {
    BigInteger bigInt =
        (BigInteger) PrimitiveObjectFactory.getInstance().getObject(BigInteger.class, "");
    Assert.assertEquals(bigInt, BigInteger.ZERO);

    bigInt = (BigInteger) PrimitiveObjectFactory.getInstance().getObject(BigInteger.class, null);
    Assert.assertEquals(bigInt, BigInteger.ZERO);
  }

  @Test
  public void testPrimitiveBoolean() {
    Boolean bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, "1");
    Assert.assertEquals(bool, true);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, "true");
    Assert.assertEquals(bool, true);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, "TRUE");
    Assert.assertEquals(bool, true);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, "0");
    Assert.assertEquals(bool, false);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, "false");
    Assert.assertEquals(bool, false);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, "FALSE");
    Assert.assertEquals(bool, false);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.TYPE, "1");
    Assert.assertEquals(bool, true);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.TYPE, "true");
    Assert.assertEquals(bool, true);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.TYPE, "TRUE");
    Assert.assertEquals(bool, true);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.TYPE, "0");
    Assert.assertEquals(bool, false);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.TYPE, "false");
    Assert.assertEquals(bool, false);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.TYPE, "FALSE");
    Assert.assertEquals(bool, false);
  }

  @Test
  public void testPrimitiveBooleanNull() {
    Boolean bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, "");
    Assert.assertEquals(bool, false);

    bool = (Boolean) PrimitiveObjectFactory.getInstance().getObject(Boolean.class, null);
    Assert.assertEquals(bool, false);
  }

  @Test
  public void testPrimitiveByte() {
    Byte byt = (Byte) PrimitiveObjectFactory.getInstance().getObject(Byte.class, "8");
    Assert.assertEquals(byt, Byte.valueOf("8"));

    byt = (Byte) PrimitiveObjectFactory.getInstance().getObject(Byte.TYPE, "8");
    Assert.assertEquals(byt, Byte.valueOf("8"));
  }

  @Test
  public void testPrimitiveByteNull() {
    Byte byt = (Byte) PrimitiveObjectFactory.getInstance().getObject(Byte.class, "");
    Assert.assertEquals(byt, Byte.valueOf("0"));

    byt = (Byte) PrimitiveObjectFactory.getInstance().getObject(Byte.class, null);
    Assert.assertEquals(byt, Byte.valueOf("0"));
  }

  @Test
  public void testPrimitiveChar() {
    Character chars = (Character) PrimitiveObjectFactory.getInstance().getObject(Character.class,
        "I don't finish anythi");
    Assert.assertEquals(chars, Character.valueOf('I'));
  }

  @Test
  public void testPrimitiveCharNull() {
    Character chars =
        (Character) PrimitiveObjectFactory.getInstance().getObject(Character.class, "");
    Assert.assertEquals(chars, Character.valueOf('\0'));

    chars = (Character) PrimitiveObjectFactory.getInstance().getObject(Character.class, null);
    Assert.assertEquals(chars, Character.valueOf('\0'));
  }

  @Test
  public void testPrimitiveDefault() {
    String value = "I don't finish anythi";
    String string =
        (String) PrimitiveObjectFactory.getInstance().getObject(UnknownError.class, value);
    Assert.assertEquals(string, value);
  }

  @Test
  public void testPrimitiveDefaultNull() {
    Object retObject = PrimitiveObjectFactory.getInstance().getObject(UnknownError.class, null);
    Assert.assertEquals(retObject, null);
  }

  @Test
  public void testPrimitiveDouble() {
    Double value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.class, "4.2");
    Assert.assertEquals(value, Double.valueOf("4.2"));

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.TYPE, "4.2");
    Assert.assertEquals(value, Double.valueOf("4.2"));
  }

  @Test
  public void testPrimitiveDoubleInfinity() {
    Double value =
        (Double) PrimitiveObjectFactory.getInstance().getObject(Double.class, "Infinity");
    Assert.assertEquals(value, Double.POSITIVE_INFINITY, 0);

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.TYPE, "Infinity");
    Assert.assertEquals(value, Double.POSITIVE_INFINITY, 0);

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.class, "INF");
    Assert.assertEquals(value, Double.POSITIVE_INFINITY, 0);

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.TYPE, "INF");
    Assert.assertEquals(value, Double.POSITIVE_INFINITY, 0);

  }

  @Test
  public void testPrimitiveDoubleNegativeInfinity() {
    Double value =
        (Double) PrimitiveObjectFactory.getInstance().getObject(Double.class, "-Infinity");
    Assert.assertEquals(value, Double.NEGATIVE_INFINITY, 0);

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.TYPE, "-Infinity");
    Assert.assertEquals(value, Double.NEGATIVE_INFINITY, 0);

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.class, "-INF");
    Assert.assertEquals(value, Double.NEGATIVE_INFINITY, 0);

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.TYPE, "-INF");
    Assert.assertEquals(value, Double.NEGATIVE_INFINITY, 0);
  }

  @Test
  public void testPrimitiveDoubleNull() {
    Double value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.class, null);
    Assert.assertEquals(value, new Double("0.0"));

    value = (Double) PrimitiveObjectFactory.getInstance().getObject(Double.TYPE, null);
    Assert.assertEquals(value, new Double("0.0"));
  }

  @Test
  public void testPrimitiveEnum() {
    // TODO PE enum test
  }

  @Test
  public void testPrimitiveFloat() {
    Float floatObject = (Float) PrimitiveObjectFactory.getInstance().getObject(Float.TYPE, "42");
    Assert.assertEquals(floatObject, Float.valueOf("42"));

    floatObject = (Float) PrimitiveObjectFactory.getInstance().getObject(Float.TYPE, "  43  ");
    Assert.assertEquals(floatObject, Float.valueOf("43"));

    floatObject = (Float) PrimitiveObjectFactory.getInstance().getObject(Float.class, "44");
    Assert.assertEquals(floatObject, Float.valueOf("44"));

    floatObject = (Float) PrimitiveObjectFactory.getInstance().getObject(Float.class, "  45  ");
    Assert.assertEquals(floatObject, Float.valueOf("45"));
  }

  @Test
  public void testPrimitiveObject() {
    Integer integer =
        (Integer) PrimitiveObjectFactory.getInstance().getObject(Integer.TYPE, "   42  ");
    Assert.assertTrue(integer == 42);

    String string = (String) PrimitiveObjectFactory.getInstance().getObject(String.class, "Hallo");
    Assert.assertEquals(string, "Hallo");
  }

  @Test
  public void testPrimitiveInteger() {
    Integer integer = (Integer) PrimitiveObjectFactory.getInstance().getObject(Integer.TYPE, "42");
    Assert.assertTrue(integer == 42);

    integer = (Integer) PrimitiveObjectFactory.getInstance().getObject(Integer.TYPE, "  43  ");
    Assert.assertTrue(integer == 43);

    integer = (Integer) PrimitiveObjectFactory.getInstance().getObject(Integer.class, "44");
    Assert.assertTrue(integer == 44);

    integer = (Integer) PrimitiveObjectFactory.getInstance().getObject(Integer.class, "  45  ");
    Assert.assertTrue(integer == 45);
  }

  @Test
  public void testPrimitiveLong() {
    Long longObject = (Long) PrimitiveObjectFactory.getInstance().getObject(Long.TYPE, "42");
    Assert.assertEquals(longObject, Long.valueOf("42"));

    longObject = (Long) PrimitiveObjectFactory.getInstance().getObject(Long.TYPE, "  43  ");
    Assert.assertEquals(longObject, Long.valueOf("43"));

    longObject = (Long) PrimitiveObjectFactory.getInstance().getObject(Long.class, "44");
    Assert.assertEquals(longObject, Long.valueOf("44"));

    longObject = (Long) PrimitiveObjectFactory.getInstance().getObject(Long.class, "  45  ");
    Assert.assertEquals(longObject, Long.valueOf("45"));
  }

  @Test
  public void testPrimitiveShort() {
    Short shortObject = (Short) PrimitiveObjectFactory.getInstance().getObject(Short.TYPE, "42");
    Assert.assertEquals(shortObject, Short.valueOf("42"));

    shortObject = (Short) PrimitiveObjectFactory.getInstance().getObject(Short.TYPE, "  43  ");
    Assert.assertEquals(shortObject, Short.valueOf("43"));

    shortObject = (Short) PrimitiveObjectFactory.getInstance().getObject(Short.class, "44");
    Assert.assertEquals(shortObject, Short.valueOf("44"));

    shortObject = (Short) PrimitiveObjectFactory.getInstance().getObject(Short.class, "  45  ");
    Assert.assertEquals(shortObject, Short.valueOf("45"));
  }

  @Test
  public void testPrimitiveString() {
    String value = "I don't finish anythi";
    String string =
        (String) PrimitiveObjectFactory.getInstance().getObject(UnknownError.class, value);
    Assert.assertEquals(string, value);
  }

}
