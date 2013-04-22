package com.continuuity.data.operation.executor.omid;

import com.continuuity.common.conf.CConfiguration;
import com.continuuity.data.hbase.HBaseTestBase;
import com.continuuity.data.operation.executor.OperationExecutor;
import com.continuuity.data.runtime.DataFabricDistributedModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class  TestHBaseOmidTransactionalOperationExecutor  extends TestOmidTransactionalOperationExecutor {

  private static OmidTransactionalOperationExecutor executor;

  @BeforeClass
  public static void startEmbeddedHBase() {
    try {
      HBaseTestBase.startHBase();
      CConfiguration conf = CConfiguration.create();
      // make sure we use vanilla hbase
      conf.setBoolean(DataFabricDistributedModule.CONF_ENABLE_NATIVE_QUEUES, false);
      Injector injector = Guice.createInjector(
        new DataFabricDistributedModule(HBaseTestBase.getConfiguration(), conf));
      executor = (OmidTransactionalOperationExecutor) injector.getInstance(
        Key.get(OperationExecutor.class, Names.named("DataFabricOperationExecutor")));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @AfterClass
  public static void stopEmbeddedHBase() {
    try {
      HBaseTestBase.stopHBase();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected OmidTransactionalOperationExecutor getOmidExecutor() {
    return executor;
  }
}
