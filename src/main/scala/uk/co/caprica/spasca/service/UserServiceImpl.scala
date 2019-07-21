/*
 * This file is part of Spa.
 *
 * Copyright (C) 2019
 * Caprica Software Limited (capricasoftware.co.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
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

package uk.co.caprica.spasca.service

import uk.co.caprica.spasca.domain.User
import uk.co.caprica.spasca.repository.MemoryUserRepository

class UserServiceImpl extends UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userRepository = new MemoryUserRepository

    @Override def users: List[User] = userRepository.readUsers

    @Override def user(username: String): Option[User] = userRepository.readUser(username)

}
