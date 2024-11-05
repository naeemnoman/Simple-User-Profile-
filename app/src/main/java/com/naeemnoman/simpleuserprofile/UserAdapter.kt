package com.naeemnoman.simpleuserprofile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(private var users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.userName)
        private val emailTextView: TextView = itemView.findViewById(R.id.userEmail)
        private val phoneTextView: TextView = itemView.findViewById(R.id.userPhone)
        private val addressTextView: TextView = itemView.findViewById(R.id.userAddress)

        fun bind(user: User) {

            nameTextView.text = user.name
            emailTextView.text = user.email
            phoneTextView.text = user.phone
            addressTextView.text = user.address.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size


    fun updateData(newData: List<User>) {
        users = newData
        notifyDataSetChanged()
    }
}

