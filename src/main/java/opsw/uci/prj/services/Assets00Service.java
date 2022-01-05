/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.services;

import java.util.List;
import opsw.uci.prj.entity.Assets00;
import org.springframework.stereotype.Component;

/**
 *
 * @author oulis
 */
@Component
public interface Assets00Service
{
  public List<Assets00> Assets00List01(Byte status);
}
