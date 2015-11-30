package com.bl_lia.realmtoy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuki_fn on 11/30/15.
 */
public class TodoAdapter extends RecyclerView.Adapter {

    final List<Todo> mTodoList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final View view = LayoutInflater.from(context).inflate(TodoItemViewHolder.getResourceId(context), parent, false);
        return TodoItemViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Todo todo = mTodoList.get(position);
        if (holder instanceof TodoItemViewHolder) {
            ((TodoItemViewHolder) holder).applyTodo(todo);
        }
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

    public void resetTodo(List<Todo> todoList) {
        mTodoList.clear();
        mTodoList.addAll(todoList);
        notifyDataSetChanged();
    }

    static class TodoItemViewHolder extends RecyclerView.ViewHolder {

        private static final String RESOURCE_ID = "list_row_todo";

        @Bind(R.id.text_name) TextView mName;
        @Bind(R.id.checkbox) CheckBox mCheckBox;

        public static int getResourceId(Context context) {
            return context.getResources().getIdentifier(RESOURCE_ID, "layout", context.getPackageName());
        }

        public static TodoItemViewHolder newInstance(View parent) {
            return new TodoItemViewHolder(parent);
        }

        public TodoItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void applyTodo(Todo todo) {
            mName.setText(todo.getName());
            mCheckBox.setChecked(todo.isChecked());
        }
    }
}
