/*
 * Copyright (c) [2021] Payara Foundation and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xyz.pagliares.jakarta.datasources.datasourcejdbc.entity;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@ApplicationScoped
public class CompanyService {

    @Resource(name = "jdbc/__default")
    private DataSource dataSource;

    public Company findCompany(Long id) {
        Company result = null;
        try (Connection connection = dataSource.getConnection()){
            try (PreparedStatement statement = connection.prepareStatement("SELECT id, name FROM Company WHERE id = ?")) {
                statement.setLong(1,id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()){
                        result = new Company(resultSet.getLong(1),resultSet.getString(2));
                    }
                }
            }
        } catch (SQLException throwables) {
            // FIXME
        }
        return result;
    }

    public List<Company> allCompanies() {
        return null;
    }

    public Company insertCompany(Company company) {

        return company;
    }
}
