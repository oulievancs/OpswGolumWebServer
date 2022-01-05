/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.entity.Gram01;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
public interface Gram01Service
{

  public List<Gram01> Gram01List01(Long gram);
}
