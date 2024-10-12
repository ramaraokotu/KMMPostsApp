//
//  PostListScreen.swift
//  iosApp
//
//  Created by itsupport on 12/10/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared
import UIKit

extension Post:Identifiable {}

extension PostsListView {
    
    struct ShowLoading: View {
        var body: some View {
            VStack {
                ProgressView("Loading...")
                    .padding()
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .background(Color.white.opacity(0.8))
        }
    }
    
    struct ShowError: View {
        
        var body: some View {
            VStack {
                Text("Error occurred")
                    .font(.headline)
                    .foregroundColor(.red)
                    .padding()
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .background(Color.white.opacity(0.8))
        }
    }
    
    
    func PostView(content: [Post]) -> some View {
        NavigationView {
            VStack {
                List {
                    ForEach(content) { post in
                        PostViewCard(post: post)
                    }
                }.listStyle(.plain)
            }
            .navigationBarTitle("Posts")
        }
    }
    
    
    struct PostViewCard: View {
        let post: Post
        
        var body: some View {
            VStack(alignment: .leading) {
                TitleText(title: post.title)
                DescriptionText(description: post.body)
            }
            .padding()
        }
    }
    
    struct TitleText: View {
        let title: String
        
        var body: some View {
            Text(title)
                .font(.headline)
                .lineLimit(2)
                .padding(.bottom, 2)
        }
    }
    
    struct DescriptionText: View {
        let description: String?
        
        var body: some View {
            if let description = description, !description.isEmpty {
                Text(description)
                    .font(.subheadline)
                    .lineLimit(3)
                    .foregroundColor(.black)
            }
        }
    }
    
}


struct PostsListView: View {
    @ObservedObject var viewModel = PostViewModel()
    @State var gotoDetailPage = false
    
    var body: some View {
        VStack {
            switch viewModel.viewState {
            case .loading:  ShowLoading()
            case .content: PostView(content: viewModel.displayPosts)
            case .error:ShowError()
            }
        }
        .onAppear {
            viewModel.getPosts()
        }
    }
}

