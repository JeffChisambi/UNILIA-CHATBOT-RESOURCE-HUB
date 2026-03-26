package com.example.uniliachatboat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private List<ChatMessage> chatMessages;
    private EditText messageInput;
    private ImageButton sendButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = view.findViewById(R.id.chat_recycler_view);
        messageInput = view.findViewById(R.id.message_input);
        sendButton = view.findViewById(R.id.send_button);

        chatMessages = new ArrayList<>();
        chatMessages.add(new ChatMessage("Hello! I'm your Unilia chat assistant. How can I help you today?", ChatMessage.TYPE_BOT));
        
        adapter = new ChatAdapter(chatMessages);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();
            if (!message.isEmpty()) {
                chatMessages.add(new ChatMessage(message, ChatMessage.TYPE_USER));
                adapter.notifyItemInserted(chatMessages.size() - 1);
                recyclerView.scrollToPosition(chatMessages.size() - 1);
                messageInput.setText("");
                
                // Optional: Fake bot response
                recyclerView.postDelayed(() -> {
                    chatMessages.add(new ChatMessage("Sorry we are currently working on this feature: " + message, ChatMessage.TYPE_BOT));
                    adapter.notifyItemInserted(chatMessages.size() - 1);
                    recyclerView.scrollToPosition(chatMessages.size() - 1);
                }, 1000);
            }
        });

        return view;
    }
}