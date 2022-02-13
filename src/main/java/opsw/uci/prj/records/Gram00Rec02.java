/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records;

import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Gram00;
import opsw.uci.prj.logic.OpswReflection;

/**
 *
 * @author oulis
 */
public class Gram00Rec02 extends Gram00
{

  private List<String> internalKeyFlds;
  private String internalKeyFldsSample;

  public Gram00Rec02()
  {
    super();
    this.internalKeyFlds = null;
    this.internalKeyFldsSample = null;
  }

  public List<String> getInternalKeyFlds()
  {
    return internalKeyFlds;
  }

  public void setInternalKeyFlds(List<String> internalKeyFlds)
  {
    this.internalKeyFlds = internalKeyFlds;
  }

  public String getInternalKeyFldsSample()
  {
    return internalKeyFldsSample;
  }

  public void setInternalKeyFldsSample(String internalKeyFldsSample)
  {
    this.internalKeyFldsSample = internalKeyFldsSample;
  }

  public static void Gram00ToGram00Rec02(Gram00 from, Gram00Rec02 to)
          throws CatException
  {
    OpswReflection.OpswReflectionCopyParentObject(from, to, Gram00.class);
  }

  public static void Gram00Rec02ToGram00(Gram00Rec02 from, Gram00 to)
          throws CatException
  {
    OpswReflection.OpswReflectionCopyObjectFields(from, to, Gram00.class);
  }
}
