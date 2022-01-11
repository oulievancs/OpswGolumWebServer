/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.globals;

import java.util.ArrayList;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.records.cat.CatThmlfObject02;

/**
 *
 * @author oulis
 */
public class OpswErpRecords01
{

  public static List<CatThmlfObject02> OpswListXrhshListObj()
          throws CatException
  {
    List<CatThmlfObject02> list = new ArrayList<>();

    CatThmlfObject02 obj = new CatThmlfObject02();
    obj.setCode(new Long(1));
    obj.setDescr("DEFAULT CONNECTION (ORCLH MINLO)");
    list.add(obj);

    obj = new CatThmlfObject02();
    obj.setCode(new Long(2));
    obj.setDescr("CONNECTION 1");
    list.add(obj);

    obj = new CatThmlfObject02();
    obj.setCode(new Long(3));
    obj.setDescr("CONNECTION 2");
    list.add(obj);

    return list;
  }

  public static void OpswXrhshByEtairSetConnection(OpswLoginVars wLoginVar, short ietai)
          throws CatException
  {
    try
    {
      switch (ietai)
      {
        case 1:
          wLoginVar.setConnectionDs("ORCLH_MINLO");
          break;
        case 2:
          wLoginVar.setConnectionDs("ORCLH_MINLO1");
          break;
        case 3:
          wLoginVar.setConnectionDs("ORCLH_MINLO2");
          break;
        default:
          break;
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
  }
}
