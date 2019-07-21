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

package uk.co.caprica.spasca.repository

import uk.co.caprica.spasca.domain.User

object MemoryUserRepository {

    private val users = Map(
        "boss"     -> User("boss"    , "Sword Saint Isshin"   ),
        "emma"     -> User("emma"    , "The Gentle Blade"     ),
        "emo"      -> User("emo"     , "Genichiro"            ),
        "dad"      -> User("dad"     , "Great Shinobi Owl"    ),
        "bananas"  -> User("bananas" , "Guardian Ape"         ),
        "granny"   -> User("granny"  , "Lady Butterfly"       ),
        "horseguy" -> User("horseguy", "Gyoubu Masataka Oniwa"),
        "scorchio" -> User("scorchio", "Demon of Hatred"      )
    )

}

class MemoryUserRepository extends UserRepository {

    @Override def readUsers: List[User] = MemoryUserRepository.users.values.toList

    @Override def readUser(username: String): Option[User] = MemoryUserRepository.users.get(username)

}
