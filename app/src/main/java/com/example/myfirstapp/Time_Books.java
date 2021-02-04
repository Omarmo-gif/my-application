package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Time_Books extends AppCompatActivity {
    private ArrayList<BookItem> bookItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__books);

        RecyclerView recyclerView = findViewById(R.id.time_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new BookAdapter(bookItems, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//(int frame, String title, String key_id, String favStatus, int bookimage, String pagesandreviews, String author)
        bookItems.add(new BookItem(R.drawable.container,"A landmark volume in science writing by one of the great minds of our time, Stephen Hawking’s book explores such profound questions as: How did the universe begin—and what made its start possible? Does time always flow forward? Is the universe unending—or are there boundaries? Are there other dimensions in space? What will happen when it all ends?\n" + "Told in language we all can understand, A Brief History of Time plunges into the exotic realms of black holes and quarks, of antimatter and “arrows of time,” of the big bang and a bigger God—where the possibilities are wondrous and unexpected. With exciting images and profound imagination, Stephen Hawking brings us closer to the ultimate secrets at the very heart of creation.", "A Brief History of Time","6","0",R.drawable.time1,"830 page  320 review","By Stephen Hawking",(float)4.5));
        bookItems.add(new BookItem(R.drawable.container, "It’s a simple equation--the better you use your time, the more you will accomplish, and the greater you will succeed. But the rollout of this basic theory isn’t so simple, is it? In Time Management, business author and success expert Brian Tracy says it is!In this indispensable, pocket-sized guide, Tracy reveals 21 proven time management techniques you can use immediately to gain two or more productive hours every day. Two or more! Every day!!By learning the strategies that Tracy himself has identified as the most effective and employed personally, readers having trouble fitting everything the day brings them inside a 24-hour window will learn how to:• Handle endless interruptions, meetings, emails, and phone calls • Identify your key result areas • Allocate enough time for top priority responsibilities • Batch similar tasks to preserve focus and make the most of each minute • Overcome procrastination • Determine what to delegate and what to eliminate • Utilize Program Evaluation and Review Techniques to work backward from the future . . . and ensure your most important goals are met • And moreFilled with Brian Tracy's trademark wisdom, this invaluable, time-creating resource will help you get more done, in less time . . . and with much less stress.","Time Management ","7","0",R.drawable.time2,"1502 page  923 review","By Brian Tracy",(float)5));
        bookItems.add(new BookItem(R.drawable.container, "A national bestseller when it first appeared in 1963, The Fire Next Time galvanized the nation, gave passionate voice to the emerging civil rights movement—and still lights the way to understanding race in America today.  \n" + "\"Basically the finest essay I’ve ever read. . . . Baldwin refused to hold anyone’s hand. He was both direct and beautiful all at once. He did not seem to write to convince you. He wrote beyond you.” --Ta-Nehisi Coates\n" + " At once a powerful evocation of James Baldwin's early life in Harlem and a disturbing examination of the consequences of racial injustice, the book is an intensely personal and provocative document from the iconic author of If Beale Street Could Talk and Go Tell It on the Mountain. It consists of two \"letters,\" written on the occasion of the centennial of the Emancipation Proclamation, that exhort Americans, both black and white, to attack the terrible legacy of racism. Described by The New York Times Book Review as \"sermon, ultimatum, confession, deposition, testament, and chronicle...all presented in searing, brilliant prose,\" The Fire Next Time stands as a classic of literature.\n","The Fire Next Time","8","0",R.drawable.time3,"600 page  200 review","By James Baldwin",(float)2.5));
        bookItems.add(new BookItem(R.drawable.container,"Nobody ever looked at an empty calendar and said, \"The best way to spend this time is by cramming it full of meetings!\" or got to work in the morning and thought, Today I'll spend hours on Facebook! Yet that's exactly what we do. Why?\n" + "In a world where information refreshes endlessly and the workday feels like a race to react to other people's priorities faster, frazzled and distracted has become our default position. But what if the exhaustion of constant busyness wasn't mandatory? What if you could step off the hamster wheel and start taking control of your time and attention? That's what this book is about." ,"Make Time","9","0",R.drawable.time4,"1434 page  660 review","By Jake Knapp",(float)3.5));
        bookItems.add(new BookItem(R.drawable.container,"Heartbreaking, funny, and beautifully written, The Absolutely True Diary of a Part-Time Indian, which is based on the author's own experiences, coupled with poignant drawings by Ellen Forney that reflect the character's art, chronicles the contemporary adolescence of one Native American boy as he attempts to break away from the life he was destined to live.\n" + "With a forward by Markus Zusak, interviews with Sherman Alexie and Ellen Forney, and four-color interior art throughout, this edition is perfect for fans and collectors alike.", "The Absolutely True Diary","10","0",R.drawable.time5,"785 page  465 review","By Sherman Alexie",(float)4));
        bookItems.add(new BookItem(R.drawable.container,"A gripping true story of survival, bravery, and honor in the vast Arctic wilderness during World War II, from Mitchell Zuckoff, the author of New York Times bestseller Lost in Shangri-La\n" + "On November 5, 1942, a US cargo plane slammed into the Greenland Ice Cap. Four days later, the B-17 assigned to the search-and-rescue mission became lost in a blinding storm and also crashed. Miraculously, all nine men on board survived, and the US military launched a daring rescue operation. But after picking up one man, the Grumman Duck amphibious plane flew into a severe storm and vanished.\n" + "Frozen in Time tells the story of these crashes and the fate of the survivors, bringing vividly to life their battle to endure 148 days of the brutal Arctic winter, until an expedition headed by famed Arctic explorer Bernt Balchen brought them to safety. Mitchell Zuckoff takes the reader deep into the most hostile environment on earth, through hurricane-force winds, vicious blizzards, and subzero temperatures.\n" + "Moving forward to today, he recounts the efforts of the Coast Guard and North South Polar Inc.—led by indefatigable dreamer Lou Sapienza—who worked for years to solve the mystery of the Duck’s last flight and recover the remains of its crew." ,"Frozen in Time","11","0",R.drawable.time6,"1912 page  654 review","By Mitchell Zuckoff",(float)4.5));

    }
}

