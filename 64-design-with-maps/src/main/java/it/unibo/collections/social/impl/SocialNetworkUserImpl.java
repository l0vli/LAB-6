/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */

    Map<String, List<U>> followed = new HashMap<>(); // K: nome gruppo  V: lista di followed

    List<U> allFollowed = new ArrayList<>();

    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */


    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */

    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */


    private boolean searchFollowed(final String circle, final U user){

        if(followed != null && !followed.isEmpty()){  // i search only if the map isn't empty or null

            final List<U> group = followed.get(circle);

            if(group != null && !group.isEmpty()){ // and the list ins't empty or null
                for (U element : group) {
                    if( element.getFirstName() == user.getFirstName() && element.getLastName() == user.getLastName()){ // altready followed
                        return true;
                      }
                }
            }
            
        }
        
        return false;
    }


    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        boolean already_followed = searchFollowed(circle, user);

        if(!already_followed){

            if(followed.get(circle) != null){
                followed.get(circle).add(user); // added to the group
            } else{
                List<U> followedInGroup = new ArrayList<>(); // built the list of users followed
                 followedInGroup.add(user);

                followed.put(circle, followedInGroup); // if the group doesn't already exist i create a new instance for it
            }
            
            allFollowed.add(user);  // added to the list of all followers

            return true;
        }

        return false;
    }

    /*
    in the methods below i only return a copy cause i don't want
    users to change parameters of the class from the main
     */  

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {

        Collection<U> copy = new ArrayList<>();

        if (followed.containsKey(groupName)){

            copy.addAll(followed.get(groupName));
            return copy;
        }
        
        return copy;
        
    }

    @Override
    public List<U> getFollowedUsers() {

        List<U> copy = new ArrayList<>();
        copy.addAll(allFollowed);

        return copy;
    }
}
