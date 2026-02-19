package src.design05_SplitWise_App.group;


import src.design05_SplitWise_App.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groups;

    public GroupController() {
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group){
        groups.add(group);
    }
    public List<Group> getGroups(){
        return groups;
    }

    public Group getGroupByID(String id){
        for(Group u:groups){
            if(u.getId().equalsIgnoreCase(id)){
                return u;
            }
        }
        return null;
    }

    public Group createGroup(String id, String descripion, User user){
        Group group=new Group(id,descripion);
        group.addMember(user);
        groups.add(group);
        return group;
    }
}
