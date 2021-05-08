//package com.example.tuschats.Activities;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.tuschats.Models.FindFriends;
//import com.example.tuschats.R;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.squareup.picasso.Picasso;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//public class Find extends AppCompatActivity {
//    private ImageButton SearchButton;
//    private EditText SearchInputText;
//    private RecyclerView SearchResultList;
//    private DatabaseReference allUserDatabaseRef;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_find);
//        allUserDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users");
//
//        SearchResultList = (RecyclerView) findViewById(R.id.search_result_list);
//        SearchResultList.setHasFixedSize(true);
//        SearchResultList.setLayoutManager(new LinearLayoutManager(this));
//
//        SearchButton = (ImageButton) findViewById(R.id.search_people_friends_button);
//        SearchInputText = (EditText) findViewById(R.id.search_box_input);
//
//        SearchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String searchBoxInput = SearchInputText.getText().toString();
//                SearchPeopleAndFriends(searchBoxInput);
//            }
//        });
//    }
//    private void SearchPeopleAndFriends(String searchBoxInput){
//        Toast.makeText(Find.this,"Searching ... ",Toast.LENGTH_LONG).show();
//        Query searchPeopleanFriendsQuery = allUserDatabaseRef.orderByChild("fullname").startAt(searchBoxInput).endAt(searchBoxInput+"\uf8ff");
//        FirebaseRecyclerAdapter<FindFriends, FindFriendsViewHolder> firebaseRecyclerAdapter =
//                new FirebaseRecyclerAdapter<FindFriends, FindFriendsViewHolder>
//                        (
//                                FindFriends.class,
//                                R.layout.row_conversation,
//                                FindFriendsViewHolder.class,
//                                searchPeopleanFriendsQuery
//                        )
//                {
//
//                    @Override
//                    protected void populateViewHolder(FindFriendsViewHolder viewHolder, FindFriends model, int position)
//                    {
//                        viewHolder.setFullname(model.getFullname());
//                        viewHolder.setProfileimage( model.getProfileimage());
//                        viewHolder.setStatus( model.getStatus());
//
//                    }
//                };
//        SearchResultList.setAdapter(firebaseRecyclerAdapter);
//    }
//    public static class FindFriendsViewHolder extends RecyclerView.ViewHolder
//    {
//        View mView;
//
//        public FindFriendsViewHolder(View itemView)
//        {
//            super(itemView);
//            mView = itemView;
//        }
//
//        public void setFullname(String fullname)
//        {
//            TextView myName = (TextView) mView.findViewById(R.id.username);
//            myName.setText(fullname);
//        }
//
//        public void setProfileimage( String profileimage)
//        {
//            CircleImageView myImage = (CircleImageView) mView.findViewById(R.id.profile);
//            Picasso.get().load(profileimage).into(myImage);
//        }
//
//
//        public void setStatus(String status)
//        {
//            TextView myStatus = (TextView) mView.findViewById(R.id.lastMsg);
//            myStatus.setText(status);
//        }
//    }
//}