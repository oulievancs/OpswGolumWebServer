/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.arifacts;

import java.util.Map;
import javax.sql.DataSource;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author e.oulis
 */
public class OpswDatasourceConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl
{

  @Autowired
  private Map<String, DataSource> opswDataSources;

  @Override
  protected DataSource selectAnyDataSource()
  {
    return (DataSource) this.opswDataSources.values().iterator().next();
  }

  @Override
  protected DataSource selectDataSource(String string)
  {
    return (DataSource) this.opswDataSources.get(string);
  }

}
