/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.frostwire.jlibtorrent.swig;

public class entry {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected entry(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(entry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_entry(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public entry.data_type type() {
    return entry.data_type.swigToEnum(libtorrent_jni.entry_type(swigCPtr, this));
  }

  public entry(string_entry_map arg0) {
    this(libtorrent_jni.new_entry__SWIG_0(string_entry_map.getCPtr(arg0), arg0), true);
  }

  public entry(String arg0) {
    this(libtorrent_jni.new_entry__SWIG_1(arg0), true);
  }

  public entry(entry_list arg0) {
    this(libtorrent_jni.new_entry__SWIG_2(entry_list.getCPtr(arg0), arg0), true);
  }

  public entry(long arg0) {
    this(libtorrent_jni.new_entry__SWIG_3(arg0), true);
  }

  public entry(entry.data_type t) {
    this(libtorrent_jni.new_entry__SWIG_4(t.swigValue()), true);
  }

  public entry(entry e) {
    this(libtorrent_jni.new_entry__SWIG_5(entry.getCPtr(e), e), true);
  }

  public entry() {
    this(libtorrent_jni.new_entry__SWIG_6(), true);
  }

  public boolean op_eq(entry e) {
    return libtorrent_jni.entry_op_eq(swigCPtr, this, entry.getCPtr(e), e);
  }

  public boolean op_neq(entry e) {
    return libtorrent_jni.entry_op_neq(swigCPtr, this, entry.getCPtr(e), e);
  }

  public long integer() {
    return libtorrent_jni.entry_integer(swigCPtr, this);
  }

  public String string() {
    return libtorrent_jni.entry_string(swigCPtr, this);
  }

  public entry_list list() {
    return new entry_list(libtorrent_jni.entry_list(swigCPtr, this), false);
  }

  public string_entry_map dict() {
    return new string_entry_map(libtorrent_jni.entry_dict(swigCPtr, this), false);
  }

  public void swap(entry e) {
    libtorrent_jni.entry_swap(swigCPtr, this, entry.getCPtr(e), e);
  }

  public entry find_key(String key) {
    long cPtr = libtorrent_jni.entry_find_key(swigCPtr, this, key);
    return (cPtr == 0) ? null : new entry(cPtr, false);
  }

  public String to_string() {
    return libtorrent_jni.entry_to_string(swigCPtr, this);
  }

  public void setM_type_queried(short value) {
    libtorrent_jni.entry_m_type_queried_set(swigCPtr, this, value);
  }

  public short getM_type_queried() {
    return libtorrent_jni.entry_m_type_queried_get(swigCPtr, this);
  }

  public entry(byte_vector string_bytes) {
    this(libtorrent_jni.new_entry__SWIG_7(byte_vector.getCPtr(string_bytes), string_bytes), true);
  }

  public entry get(String key) {
    return new entry(libtorrent_jni.entry_get(swigCPtr, this, key), false);
  }

  public void set(String key, String value) {
    libtorrent_jni.entry_set__SWIG_0(swigCPtr, this, key, value);
  }

  public void set(String key, byte_vector value) {
    libtorrent_jni.entry_set__SWIG_1(swigCPtr, this, key, byte_vector.getCPtr(value), value);
  }

  public void set(String key, int value) {
    libtorrent_jni.entry_set__SWIG_2(swigCPtr, this, key, value);
  }

  public byte_vector string_bytes() {
    return new byte_vector(libtorrent_jni.entry_string_bytes(swigCPtr, this), true);
  }

  public byte_vector bencode() {
    return new byte_vector(libtorrent_jni.entry_bencode(swigCPtr, this), true);
  }

  public static entry bdecode(byte_vector buffer) {
    return new entry(libtorrent_jni.entry_bdecode(byte_vector.getCPtr(buffer), buffer), true);
  }

  public final static class data_type {
    public final static entry.data_type int_t = new entry.data_type("int_t");
    public final static entry.data_type string_t = new entry.data_type("string_t");
    public final static entry.data_type list_t = new entry.data_type("list_t");
    public final static entry.data_type dictionary_t = new entry.data_type("dictionary_t");
    public final static entry.data_type undefined_t = new entry.data_type("undefined_t");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static data_type swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + data_type.class + " with value " + swigValue);
    }

    private data_type(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private data_type(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private data_type(String swigName, data_type swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static data_type[] swigValues = { int_t, string_t, list_t, dictionary_t, undefined_t };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
