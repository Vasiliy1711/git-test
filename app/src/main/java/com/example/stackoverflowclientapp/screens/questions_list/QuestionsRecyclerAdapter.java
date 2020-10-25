package com.example.stackoverflowclientapp.screens.questions_list;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stackoverflowclientapp.questions.Question;
import com.example.stackoverflowclientapp.screens.common.ViewMvcFactory;
import com.example.stackoverflowclientapp.screens.questions_list.questionslistitem.QuestionsListItemViewMvc;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRecyclerAdapter extends RecyclerView.Adapter<QuestionsRecyclerAdapter.MyViewHolder>
        implements QuestionsListItemViewMvc.Listener
{
    public interface Listener
    {
        void onQuestionClicked(Question question);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private final QuestionsListItemViewMvc mViewMvc;

        public MyViewHolder(QuestionsListItemViewMvc viewMvc)
        {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    private final Listener mListener;
    private ViewMvcFactory mViewMvcFactory;
    private List<Question> mQuestions = new ArrayList<>();

    public QuestionsRecyclerAdapter(Listener listener, ViewMvcFactory viewMvcFactory)
    {
        mListener = listener;
        mViewMvcFactory = viewMvcFactory;
    }

    public void bindQuestions(List<Question> questions)
    {
        mQuestions = new ArrayList<>(questions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        QuestionsListItemViewMvc viewMvc = mViewMvcFactory.getQuestionsListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.mViewMvc.bindQuestion(mQuestions.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mQuestions.size();
    }

    @Override
    public void onQuestionClicked(Question question)
    {
        mListener.onQuestionClicked(question);
    }
}
