/*
 *
 *  * Copyright 2019-2020 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package springfox.test.contract.oas.repository;

import org.springframework.stereotype.Repository;
import springfox.test.contract.oas.model.Order;

@Repository
public class OrderRepository extends HashMapRepository<Order, Long> {

  public OrderRepository() {
    super(Order.class);
  }

  @Override
  <S extends Order> Long getEntityId(S order) {
    return order.getId();
  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {
    for (Long aLong : longs) {
      entities.remove(aLong);
    }
  }
}
